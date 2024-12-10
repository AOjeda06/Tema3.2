package boletin1;

import java.util.Scanner;

public class Ej2VersionAvanzada {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Variables
		String contraseña;
		String intento;
		boolean win = false;

		// Pide la contraseña y guarda su valor
		System.out.println("Escribe la contraseña");
		contraseña = scanner.next();

		while (!win) {
			System.out.println("Intenta adivinar la contraseña");
			intento = scanner.next();

			// Comprobamos que la longitud de la contraseña y el intento coincidan
			if (intento.length() != contraseña.length()) {
				System.out.println("El intento debe tener la misma longitud que la contraseña.");
				continue;
			}

			// Comprobamos si el intento es correcto
			if (intento.equals(contraseña)) {
				win = true;
			} else {
				// Si no acierta, mostramos los caracteres acertados y los incorrectos como
				// asteriscos
				StringBuilder resultado = new StringBuilder();
				for (int i = 0; i < contraseña.length(); i++) {
					if (contraseña.charAt(i) == intento.charAt(i)) {
						resultado.append(contraseña.charAt(i)); // Si acierta, muestra el carácter
					} else {
						resultado.append('*'); // Si no acierta, muestra un asterisco
					}
				}
				System.out.println("Resultado: " + resultado.toString());
			}
		}

		System.out.println("¡Has adivinado la contraseña!");

		scanner.close();
	}
}
