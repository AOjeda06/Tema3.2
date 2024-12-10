package boletin1;

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;
		String frase2;
		int comparacion;
		boolean win = false;

		// Pide los datos y guarda sus valores
		System.out.println("Escribe la contraseña");
		frase1 = scanner.next();

		// Bucle dentro del que juega el jugador 2
		while (!win) {

			// Lee la respuesta y la almacena
			System.out.println("Intenta adivinar la contraseña");
			frase2 = scanner.next();

			// Comprueba si ha acertado
			if (frase1.equals(frase2)) {
				win = true;
				// Si no acierta mide si se ha pasado o se ha quedado corto
			} else {
				comparacion = frase1.compareTo(frase2);

				if (comparacion < 0) {
					System.out.println("La palabra introducida es alfabéticamente mayor");
				} else {
					System.out.println("La palabra introducida es alfabéticamente menor");
				}
			}

		}

		// Mensaje final
		System.out.println("Has adivinado la contraseña!");

		// Cerramos el scanner
		scanner.close();
	}

}
