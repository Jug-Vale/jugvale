package br.com.jugvale.entity.palestra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jugvale.entity.EntidadeAbstrata;
import br.com.jugvale.entity.palestrante.Palestrante;
import br.com.jugvale.pojos.palestras.PalestraPojo;
import br.com.jugvale.util.data.UtilData;

@Entity
@Table(name = "palestra")
public class Palestra extends EntidadeAbstrata {

	private static final long serialVersionUID = 1L;

	public Palestra() {
	}

	public Palestra(String titulo, String tema, String horaApresentacao, Palestrante palestrante) {
		this.titulo = titulo;
		this.tema = tema;
		this.horaApresentacao = UtilData.converteDataStringParaDate(horaApresentacao, "HH:mm");
		this.palestrante = palestrante;
	}

	@Column(name = "titulo", nullable = false, length = 100)
	private String titulo;

	@Column(name = "tema", nullable = false, length = 255)
	private String tema;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_palestra", nullable = false, length = 8)
	private Date horaApresentacao;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_palestrante", nullable = false)
	private Palestrante palestrante;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Date getHoraApresentacao() {
		return horaApresentacao;
	}

	public void setHoraApresentacao(Date horaApresentacao) {
		this.horaApresentacao = horaApresentacao;
	}

	public Palestrante getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

	public PalestraPojo constroiPalestraPojo() {
		return new PalestraPojo(titulo, tema, horaApresentacao, palestrante);
	}

	public Collection<PalestraPojo> constroiListaPalestrasPojo(Collection<Palestra> palestras) {
		Collection<PalestraPojo> palestrasPojo = new ArrayList<PalestraPojo>();
		for (Palestra palestra : palestras) {
			palestrasPojo.add(palestra.constroiPalestraPojo());
		}

		return palestrasPojo;
	}

}
