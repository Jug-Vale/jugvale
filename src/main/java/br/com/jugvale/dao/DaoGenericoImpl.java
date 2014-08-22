package br.com.jugvale.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public class DaoGenericoImpl<T, ID extends Serializable> {

	private final Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() throws HibernateException {
		if (sessionFactory.isClosed()) {
			return sessionFactory.openSession();
		}
		return sessionFactory.getCurrentSession();
	}

	public Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	public DaoGenericoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T save(T t) throws Exception {
		try {
			getCurrentSession().save(t);
			return t;
		} catch (Exception e) {
			throw new Exception("dao.salvar.erro");
		}
	}

	public void saveList(List<T> t) throws Exception {
		try {
			for (T obj : t) {
				getCurrentSession().save(obj);
			}
		} catch (Exception e) {
			throw new Exception("dao.salvar.erro");
		}
	}

	public long saveId(T t) throws Exception {
		try {
			return (Long) getCurrentSession().save(t);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("dao.salvar.erro");
		}
	}

	public T merge(T t) throws Exception {
		try {
			return (T) getCurrentSession().merge(t);
		} catch (Exception e) {
			throw new Exception("dao.update.erro");
		}
	}

	public void mergeList(List<T> t) throws Exception {
		try {
			for (T obj : t) {
				getCurrentSession().merge(obj);
			}
		} catch (Exception e) {
			throw new Exception("dao.salvar.erro");
		}
	}

	public void remove(T t) throws Exception {
		try {
			getCurrentSession().delete(t);
		} catch (Exception e) {
			throw new Exception("dao.remover.erro");
		}
	}

	public T findById(ID id) throws Exception {
		try {
			return (T) getCurrentSession().get(getPersistentClass(), id);
		} catch (Exception e) {
			throw new Exception("dao.findbyid.erro");
		}
	}

	public void removeAll(String tabela) throws Exception {
		try {
			Session sessao = getCurrentSession();

			sessao.createSQLQuery("DELETE FROM " + tabela).executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao Excluir Todos os Registros da Tabela regra");
		}
	}

}
