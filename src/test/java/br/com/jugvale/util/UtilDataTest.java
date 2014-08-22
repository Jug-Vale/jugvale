package br.com.jugvale.util;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import br.com.jugvale.util.data.UtilData;

public class UtilDataTest {

	@Test
	public void testaConverteHoraStringEmDate() throws Exception {
		Date hora = UtilData.converteDataStringParaDate("12:12:12", "HH:mm");
		assertEquals(54720000L, hora.getTime());
	}

	@Test
	public void testaConverteHoraDateParaString() throws Exception {
		Date horaDate = UtilData.converteDataStringParaDate("12:12:12", "HH:mm");
		String hora = UtilData.converteHoraDateParaString(horaDate);

		assertEquals("12:12:00", hora);
	}

	@Test
	public void testaConverteDataDateParaString() throws Exception {
		Date dataDate = UtilData.converteDataStringParaDate("24/2/1990", "dd/MM/yyyy");
		String data = UtilData.converteDataDateParaString(dataDate);

		assertEquals("24/2/1990", data);
	}
}
