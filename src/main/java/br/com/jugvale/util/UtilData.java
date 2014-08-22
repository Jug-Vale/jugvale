package br.com.jugvale.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilData {

	public static String converteHoraDateParaString(Date data) {

		if (data == null) {
			return null;
		}

		GregorianCalendar gregCalendar = new GregorianCalendar();
		gregCalendar.setTime(data);

		int hora = gregCalendar.get(GregorianCalendar.HOUR_OF_DAY);
		int minuto = gregCalendar.get(GregorianCalendar.MINUTE);

		return hora + ":" + minuto + ":00";
	}

	public static String converteDataDateParaString(Date data) {

		if (data == null) {
			return null;
		}

		GregorianCalendar gregCalendar = new GregorianCalendar();
		gregCalendar.setTime(data);

		int dia = gregCalendar.get(GregorianCalendar.DATE);
		int mes = gregCalendar.get(GregorianCalendar.MONTH) + 1;
		int ano = gregCalendar.get(GregorianCalendar.YEAR);

		return dia + "/" + mes + "/" + ano;
	}

	public static Date converteDataStringParaDate(String data, String formato) {

		if (data == null || data.equals("")) {
			return null;
		}

		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(formato);
			date = formatter.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
