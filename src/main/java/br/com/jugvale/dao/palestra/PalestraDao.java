package br.com.jugvale.dao.palestra;

import org.springframework.stereotype.Repository;

import br.com.jugvale.dao.DaoGenericoImpl;
import br.com.jugvale.entity.palestra.Palestra;

@Repository("palestraDao")
public class PalestraDao extends DaoGenericoImpl<Palestra, Long> {

}
