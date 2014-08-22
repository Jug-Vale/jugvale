package br.com.jugvale.entity.evento;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.jugvale.entity.EntidadeAbstrata;
import br.com.jugvale.entity.palestra.Palestra;
import br.com.jugvale.pojos.evento.EventoPojo;
import br.com.jugvale.util.data.UtilData;

@Entity
@Table(name = "evento")
public class Evento extends EntidadeAbstrata {

	public Evento() {
	}

	public Evento(String edicao, String dia, String horaInicio, String horaFim, Collection<Palestra> palestras) {
		this.edicao = edicao;
		this.dia = UtilData.converteDataStringParaDate(dia, "dd/MM/yyyy");
		this.horaInicio = UtilData.converteDataStringParaDate(horaInicio, "HH:mm");
		this.horaFim = UtilData.converteDataStringParaDate(horaFim, "HH:mm");
		this.palestras = palestras;
	}

	private static final long serialVersionUID = 1L;

	@Column(name = "edicao", nullable = false, length = 100)
	private String edicao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dia", nullable = false, length = 8)
	private Date dia;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_inicio", nullable = false, length = 8)
	private Date horaInicio;

	@Temporal(TemporalType.TIME)
	@Column(name = "hora_fim", nullable = false, length = 8)
	private Date horaFim;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "evento_has_palestras", joinColumns = @JoinColumn(name = "fk_evento"), inverseJoinColumns = @JoinColumn(name = "fk_palestra"))
	private Collection<Palestra> palestras;

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public Collection<Palestra> getPalestras() {
		return palestras;
	}

	public void setPalestras(Collection<Palestra> palestras) {
		this.palestras = palestras;
	}

	public EventoPojo constroiEventoPojo() {
		return new EventoPojo(edicao, dia, horaInicio, horaFim, palestras);
	}

}
