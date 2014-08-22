package br.com.jugvale.pojos.palestras;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import br.com.jugvale.entity.palestra.Palestra;
import br.com.jugvale.entity.palestrante.Palestrante;
import br.com.jugvale.pojos.palestrante.PalestrantePojo;
import br.com.jugvale.util.data.UtilData;

public class PalestraPojo {

	public PalestraPojo() {
	}

	public PalestraPojo(String titulo, String tema, Date horaApresentacao, Palestrante palestrante) {
		this.titulo = titulo;
		this.tema = tema;
		this.horaApresentacao = UtilData.converteHoraDateParaString(horaApresentacao);
		this.palestrante = palestrante.constroiPalestrantePojo();
	}

	private String titulo;
	private String tema;
	private String horaApresentacao;
	private PalestrantePojo palestrante;

	public String getHoraApresentacao() {
		return horaApresentacao;
	}

	public void setHoraApresentacao(String horaApresentacao) {
		this.horaApresentacao = horaApresentacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTema() {
		return tema;
	}

	public PalestrantePojo getPalestrante() {
		return palestrante;
	}

	public Palestra constroiPalestra() {
		return new Palestra(titulo, tema, horaApresentacao, palestrante.constroiPalestrante());
	}

	public Collection<Palestra> constroiListaPalestras(Collection<PalestraPojo> palestrasPojo) {
		Collection<Palestra> palestras = new ArrayList<Palestra>();
		for (PalestraPojo palestraPojo : palestrasPojo) {
			palestras.add(palestraPojo.constroiPalestra());
		}

		return palestras;
	}
}
