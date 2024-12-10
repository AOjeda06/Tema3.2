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

		System.out.println(palindrona(frase1));

		scanner.close();

	}

	public static boolean palindrona(String frase) {
		boolean es = true;

		for (int i = 0; i < frase.length(); i++) {
		}

		return es;

	}

}
