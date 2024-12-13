package boletin1;

import java.util.Scanner;

public class Ej12 {

	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Pide una frase al usuario
		System.out.println("Escribe una frase:");
		String frase = scanner.nextLine();

		// Llama a la función para encontrar la palabra más larga
		String palabraMasLarga = encontrarPalabraMasLarga(frase);

		// Imprime la palabra más larga y su longitud
		System.out.println("La palabra más larga es: " + palabraMasLarga);
		System.out.println("Número de caracteres: " + palabraMasLarga.length());

		// Cerramos el scanner
		scanner.close();
	}

	// Función para encontrar la palabra más larga en una frase
	public static String encontrarPalabraMasLarga(String frase) {
		// Dividir la frase en palabras usando el espacio como delimitador
		String[] palabras = frase.split(" ");
		String palabraMasLarga = "";

		// Recorrer todas las palabras
		for (String palabra : palabras) {
			// Si la palabra actual es más larga que la palabra más larga encontrada hasta
			// ahora
			if (palabra.length() > palabraMasLarga.length()) {
				// Actualizar la palabra más larga
				palabraMasLarga = palabra;
			}
		}

		return palabraMasLarga;
	}
}
