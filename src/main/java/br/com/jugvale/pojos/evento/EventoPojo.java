package br.com.jugvale.pojos.evento;

import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.jugvale.entity.evento.Evento;
import br.com.jugvale.entity.palestra.Palestra;
import br.com.jugvale.pojos.palestras.PalestraPojo;
import br.com.jugvale.util.data.UtilData;

@XmlRootElement
public class EventoPojo {

	public EventoPojo() {
	}

	public EventoPojo(String edicao, Date dia, Date horaInicio, Date horaFim, Collection<Palestra> palestras) {
		this.edicao = edicao;
		this.dia = UtilData.converteDataDateParaString(dia);
		this.horaInicio = UtilData.converteHoraDateParaString(horaInicio);
		this.horaFim = UtilData.converteHoraDateParaString(horaFim);
		this.palestras = new Palestra().constroiListaPalestrasPojo(palestras);
	}

	private String edicao;
	private String dia;
	private String horaInicio;
	private String horaFim;
	private Collection<PalestraPojo> palestras;

	public String getEdicao() {
		return edicao;
	}

	public String getDia() {
		return dia;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public Collection<PalestraPojo> getPalestras() {
		return palestras;
	}

	public Evento constroiEvento() {
		Collection<Palestra> listaPalestras = new PalestraPojo().constroiListaPalestras(palestras);
		return new Evento(edicao, dia, horaInicio, horaFim, listaPalestras);
	}
}
