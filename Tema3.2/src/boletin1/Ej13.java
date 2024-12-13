package boletin1;

import java.util.Arrays;
import java.util.Scanner;

public class Ej13 {

	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String palabra1;
		String palabra2;
		char[] letras1;
		char[] letras2;

		System.out.println("Introduce la primera palabra");
		palabra1 = scanner.nextLine().toLowerCase(); // Asignar el resultado de toLowerCase()
		System.out.println("Introduce la segunda palabra");
		palabra2 = scanner.nextLine().toLowerCase(); // Asignar el resultado de toLowerCase()

		// Convertir las palabras a arrays de caracteres
		letras1 = palabra1.toCharArray();
		letras2 = palabra2.toCharArray();

		// Ordenar los arrays
		Arrays.sort(letras1);
		Arrays.sort(letras2);

		// Comparar los arrays ordenados
		if (Arrays.equals(letras1, letras2)) {
			System.out.println("Son anagramas");
		} else {
			System.out.println("No son anagramas");
		}

		// Cerramos el scanner
		scanner.close();
	}
}
