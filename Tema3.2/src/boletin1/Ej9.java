package boletin1;

import java.util.Scanner;

public class Ej9 {

	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una frase");
		frase1 = scanner.nextLine();

		// Imprime la frase sin las muletillas
		System.out.println(traductor(frase1));

		// Cerramos el scanner
		scanner.close();
	}

	public static String traductor(String frase) {
		// Variables para muletillas
		String inicio = "Javalín, javalón";
		String fin = "javalén, len, len";
		String mensaje = frase.trim(); // Eliminar espacios en los extremos

		// Comprobar si la frase comienza con la muletilla de inicio
		if (mensaje.startsWith(inicio)) {
			// Eliminar la muletilla de inicio y los espacios
			mensaje = mensaje.substring(inicio.length()).trim();
		}

		// Comprobar si la frase termina con la muletilla de fin
		if (mensaje.endsWith(fin)) {
			// Eliminar la muletilla de fin y los espacios
			mensaje = mensaje.substring(0, mensaje.length() - fin.length()).trim();
		}

		return mensaje;
	}
}
