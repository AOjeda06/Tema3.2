package boletin1;

import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una frase");
		frase1 = scanner.nextLine();

		// LLamamos a la funcion en la impresión de la respuesta
		System.out.println("La frase introducida tiene " + espacios(frase1) + " espacios");

		// Cerramos el scanner
		scanner.close();

	}

	// Función para contar los espacios
	public static int espacios(String frase) {
		// Declaramos una variable para almacenar el numero
		int numSpace = 0;

		// Recorre el String buscando el espacio como char y aumenta el contador si lo
		// encuentra
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ' ') {
				numSpace++;
			}
		}

		// Devuelve el numero
		return numSpace;

	}
}
