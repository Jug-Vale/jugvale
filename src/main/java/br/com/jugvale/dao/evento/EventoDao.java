package br.com.jugvale.dao.evento;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.jugvale.dao.DaoGenericoImpl;
import br.com.jugvale.entity.evento.Evento;

@Repository("eventoDao")
public class EventoDao extends DaoGenericoImpl<Evento, Long> {

	public Evento buscarUltimoEventoAtivo() {
		Evento evento;
		Criteria query = getCurrentSession().createCriteria(Evento.class);

		try {
			query.add(Restrictions.eq("ativo", true)).addOrder(Order.desc("id"));
			evento = (Evento) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			evento = null;
		}

		return evento;
	}
}
