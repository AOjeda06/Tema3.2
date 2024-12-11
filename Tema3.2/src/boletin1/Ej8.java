package boletin1;

import java.util.Arrays;
import java.util.Scanner;

public class Ej8 {
	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una frase");
		frase1 = scanner.nextLine();

		// Imprime la frase con las palabras ordenadas
		System.out.println(ordena(frase1));

		// Cerramos el scanner
		scanner.close();
	}

	public static String ordena(String frase) {
		String[] palabras;

		// Dividimos la frase en palabras
		palabras = frase.split(" ");

		// Ordenamos el array de palabras alfabéticamente
		Arrays.sort(palabras);

		// Unimos las palabras ordenadas en una sola cadena, separadas por espacios
		String ordenada = String.join(" ", palabras);

		return ordenada;
	}
}
