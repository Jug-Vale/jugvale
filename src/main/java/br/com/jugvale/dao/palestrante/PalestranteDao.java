package br.com.jugvale.dao.palestrante;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.jugvale.dao.DaoGenericoImpl;
import br.com.jugvale.entity.palestrante.Palestrante;

@Repository("palestranteDao")
public class PalestranteDao extends DaoGenericoImpl<Palestrante, Long> {

	public Palestrante findByEmail(String email) throws Exception {

		Palestrante palestrante;
		Criteria select = getCurrentSession().createCriteria(Palestrante.class);

		try {
			select.add(Restrictions.eq("email", email));
			palestrante = (Palestrante) select.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
			palestrante = null;
		}

		return palestrante;
	}
}
