package br.com.jugvale.util.numerico;

public class UtilNumerico {
	public static Long converteStringParaLong(String valor) {

		try {
			return Long.parseLong(valor);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
