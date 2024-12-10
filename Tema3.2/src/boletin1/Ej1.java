package boletin1;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;
		String frase2;
		int comparacion;

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una frase");
		frase1 = scanner.nextLine();
		System.out.println("Escribe una frase");
		frase2 = scanner.nextLine();

		// Asigna la comparación a un valor
		comparacion = frase1.compareToIgnoreCase(frase2);

		// En vase al valor obtenido imprime la respuesta
		if (comparacion > 0) {
			System.out.println("la primera frase es más larga que la segunda");
		} else if (comparacion < 0) {
			System.out.println("la segunda frase es más larga que la primera");
		} else {
			System.out.println("Son las dos igual de largas");
		}

		scanner.close();
	}

}
