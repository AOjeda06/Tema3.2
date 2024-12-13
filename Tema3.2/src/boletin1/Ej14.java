package boletin1;

import java.util.Arrays;
import java.util.Scanner;

public class Ej14 {

	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase;
		char[] letras;
		int[] conteo = new int[256]; // Suponiendo los 256 caracteres de ASCII

		System.out.println("Introduce la frase");
		frase = scanner.nextLine().toLowerCase(); // Convertir a minúsculas

		letras = frase.toCharArray();

		// Ordenar el array de caracteres
		Arrays.sort(letras);

		// Suma a la posición de esa letra 1 dentro del array de ASCII
		for (char letra : letras) {
			conteo[letra]++;
		}

		// Mostrar el conteo de cada carácter que en su posición dentro del array de
		// ASCII tengan al menos 1 aparicion
		for (int i = 0; i < conteo.length; i++) {
			if (conteo[i] > 0) {
				// Hacemos un cast a i, y nos imprime la letra con ese numero dentro de ASCII
				System.out.println((char) i + ": " + conteo[i]);
			}
		}

		// Cerramos el scanner
		scanner.close();
	}
}
