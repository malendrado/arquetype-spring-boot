#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionUtil {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+${symbol_escape}${symbol_escape}.[A-Z]{2,6}${symbol_dollar}",
			Pattern.CASE_INSENSITIVE);

	/**
	 * Función para validación de RUN
	 * 
	 * @param run string
	 * 
	 * @return Boolean
	 */
	public static Boolean validateRUN(String run) {

		boolean validacion = false;
		try {
			run = normalizeRun(run);
			int rutAux = Integer.parseInt(run.substring(0, run.length() - 1));

			char dv = run.charAt(run.length() - 1);

			int m = 0, s = 1;
			for (; rutAux != 0; rutAux /= 10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}

		} catch (java.lang.NumberFormatException e) {
		} catch (Exception e) {}
		return validacion;
	}

	/**
	 * Normaliza el run quitando los . y -
	 * 
	 * @param run require rut
	 * @return devuelve rut formateado
	 */
	public static String normalizeRun(String run) {
		return run.toUpperCase().replace(".", "").replace("-", "");
	}
	
	/**
	 * Normaliza el run quitando los . - y eliminando el digito verificador
	 * Retorna la parte numerica del run
	 * @param run rut requerido
	 * @return Retorna la parte numerica del run
	 */
	public static int normalizeRunWithOutDv(String run) {
		String normalized = normalizeRun(run);
		return Integer.parseInt(normalized.substring(0, normalized.length() - 1));
	}

	/**
	 * Valida que el email posea un formato correcto
	 * 
	 * @param email string
	 * @return retorna true o false
	 */
	public static boolean validateMail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.find();
	}

	/**
	 * <p>
	 * Checks if the specified name is a valid enum for the class.
	 * </p>
	 *
	 * <p>
	 * This method differs from {@link Enum${symbol_pound}valueOf} in that checks if the name is a
	 * valid enum without needing to catch the exception.
	 * </p>
	 *
	 * @param <E>
	 *            the type of the enumeration
	 * @param enumClass
	 *            the class of the enum to query, not null
	 * @param enumName
	 *            the enum name, null returns false
	 * @return true if the enum name is valid, otherwise false
	 */
	public static <E extends Enum<E>> boolean isValidEnum(Class<E> enumClass, String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(enumClass, enumName);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}
}