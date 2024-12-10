package boletin1;

import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String frase1;

		// Pide los datos y guarda sus valores
		System.out.println("Escribe una frase");
		frase1 = scanner.nextLine();

		// Imprime la frase invertida
		System.out.println(invertida(frase1));

		// Cerramos el scanner
		scanner.close();

	}

	public static String invertida(String frase) {
		// Creamos una cadena para almacenar el String reverso
		String reversa = "";

		// Vamos colocando desde el ultimo al primer carácter del string recibido en el
		// nuevo String creado
		for (int i = 0; i < frase.length(); i++) {
			reversa += frase.charAt(frase.length() - 1 - i);
		}

		// Devuelve el String
		return reversa;

	}

}
