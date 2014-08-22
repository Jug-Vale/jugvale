package br.com.jugvale.dao.usuario;

import org.springframework.stereotype.Repository;

import br.com.jugvale.dao.DaoGenericoImpl;
import br.com.jugvale.entity.usuario.Usuario;

@Repository("usuarioDao")
public class UsuarioDao extends DaoGenericoImpl<Usuario, Long> {

}
