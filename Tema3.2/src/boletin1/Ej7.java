package boletin1;

import java.util.Scanner;

public class Ej7 {
	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;
		String palabra;

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una frase");
		frase1 = scanner.nextLine();

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una palabra");
		palabra = scanner.next();

		// Imprime cuantas veces aparece la palabra
		System.out.println("La palabra aparece: " + busca(frase1, palabra) + " veces.");

		// Cerramos el scanner
		scanner.close();
	}

	public static int busca(String frase, String palabra) {
		// Variables
		int cont = 0;
		int index = 0;

		// Bucle que va buscando la palabra
		while ((index = frase.indexOf(palabra, index)) != -1) {
			cont++;
			index += palabra.length(); // Mover el índice al final de la palabra encontrada
		}

		// Devuelve cuántas veces la ha encontrado
		return cont;
	}
}
