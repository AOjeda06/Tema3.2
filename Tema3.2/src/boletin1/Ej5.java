package boletin1;

import java.util.Scanner;

public class Ej5 {

	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;
		String check = "";
		boolean fin = false;
		int cont = 0;

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una frase");
		frase1 = scanner.nextLine();

		// Comprueba tanto que no haya ganado como que no se pase el contador
		while (!fin && cont < frase1.length()) {
			// Guarda cada palabra
			if (frase1.charAt(cont) != ' ') {
				check += frase1.charAt(cont);
				// Comprueba si es la palabra fin
			} else {
				if (check.equals("fin")) {
					fin = true;
				} else {
					// Si no es la palabra fin la imprime separada por espacios
					for (int i = 0; i < check.length(); i++) {
						System.out.print(check.charAt(i) + " ");
					}
					System.out.println(); // Añadir nueva línea después de imprimir la palabra
					check = "";
				}
			}
			// Aumentamos el contador
			cont++;
		}

		// Comprobar última palabra si no hay espacio al final
		if (check.equals("fin")) {
			fin = true;
		} else {
			for (int i = 0; i < check.length(); i++) {
				System.out.print(check.charAt(i) + " ");
			}
		}

		// Cerramos el scanner
		scanner.close();
	}
}
