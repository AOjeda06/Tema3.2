package boletin1;

import java.util.Scanner;

public class Ej6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una frase");
		frase1 = scanner.nextLine();

		// Llama a la función e imprime el resultado devuelto
		System.out.println(palindroma(frase1));

		// Cerramos el scanner
		scanner.close();

	}

	public static boolean palindroma(String frase) {
		// Variables
		boolean es = true;
		int cont = 0;

		// Pasamos todo a minúsculas
		frase = frase.toLowerCase();

		// Quitamos los espacios
		frase = frase.replaceAll("\\s", "");

		while (es && cont < frase.length() / 2) {
			if (frase.charAt(cont) != frase.charAt(frase.length() - 1 - cont)) {
				es = false;
			}
			cont++;
		}

		return es;

	}

}
