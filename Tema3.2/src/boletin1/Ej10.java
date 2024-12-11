package boletin1;

import java.util.Arrays;
import java.util.Scanner;

public class Ej10 {

	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;
		char[] conjunto1 = new char[] { 'e', 'i', 'k', 'm', 'p', 'q', 'r', 's', 't', 'u', 'v' };
		char[] conjuntoOrdenado = new char[] { 'e', 'i', 'k', 'm', 'p', 'q', 'r', 's', 't', 'u', 'v' };
		char[] conjunto2 = new char[] { 'p', 'v', 'i', 'u', 'm', 't', 'e', 'r', 'k', 'q', 's' };
		char[] frase;

		Arrays.sort(conjuntoOrdenado);

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una frase");
		frase1 = scanner.nextLine();

		frase = frase1.toCharArray();

		for (int i = 0; i < frase.length; i++) {
			if (Arrays.binarySearch(conjunto1, frase[i]) >= 0) {
				frase[i] = codifica(conjunto1, conjunto2, frase[i]);
			}
		}

		frase1 = String.valueOf(frase);

		System.out.println(frase1);

		// Cerramos el scanner
		scanner.close();
	}

	public static char codifica(char conjunto1[], char conjunto2[], char c) {

		return c;
	}

}