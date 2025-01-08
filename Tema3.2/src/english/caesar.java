package english;

public class caesar {

	public static void main(String[] args) {
		String input = "abczABCZ0189";
		int shift = -2; // Puedes probar con valores positivos o negativos aquí
		String output = caesarCipher(input, shift);
		System.out.println("Entrada: " + input);
		System.out.println("Salida: " + output);
	}

	public static String caesarCipher(String str, int shift) {
		String result = "";
		char base;
		char shifted;

		// Normaliza el shift para que sea dentro del rango
		shift = shift % 26; // Para letras, el módulo debe ser 26
		for (int i = 0; i < str.length(); i++) {
			char charAt = str.charAt(i);

			if (Character.isLetter(charAt)) {
				// Determinar la base: 'A' para mayúsculas y 'a' para minúsculas
				base = Character.isUpperCase(charAt) ? 'A' : 'a';

				// Desplazamos el carácter, asegurándonos de que no se salga del rango
				shifted = (char) ((charAt - base + shift + 26) % 26 + base);
				result += shifted;
			} else if (Character.isDigit(charAt)) {
				// Para los dígitos, el rango es de 0 a 9, así que usamos módulo 10
				shifted = (char) ((charAt - '0' + shift + 10) % 10 + '0');
				result += shifted;
				// Los caracteres no alfanuméricos se agregan tal cual
				result += charAt;
			}
		}

		return result;
	}
}
