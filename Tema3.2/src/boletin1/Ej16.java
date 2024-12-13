package boletin1;

import java.util.Random;
import java.util.Scanner;

public class Ej16 {
	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String palabra;
		char[] letras;
		String nuevaPalabra;
		boolean win = false;
		String ans = "";

		// Pide y guarda la palabra clave
		System.out.println("Jugador 1, escribe tu palabra: ");
		palabra = scanner.next().toLowerCase();

		// La convierte en un array de Chars
		letras = palabra.toCharArray();

		// Llama a la funcion que desordena arrays
		letras = desordena(letras);

		// Convierte el array desordenado en una cadena/palabra
		nuevaPalabra = new String(letras);

		// Bucle en el que se desarrolla la partida del jugador 2
		while (!win) {
			// Intento del jugador 2
			System.out.println("Jugador 2, intenta adivinar la palabra: " + nuevaPalabra);
			ans = scanner.next();

			// Comprueba si ha acertado
			if (ans.equalsIgnoreCase(palabra)) {
				win = true;
				System.out.println("¡Has acertado la palabra!");
			} else {
				// Sino comprueba los caracteres acertados
				for (int i = 0; i < palabra.length(); i++) {
					if (i < ans.length() && ans.charAt(i) == palabra.charAt(i)) {
						System.out.print(ans.charAt(i));
					} else {
						System.out.print("*");
					}
				}
				System.out.println("\nIntento incorrecto. ¡Inténtalo de nuevo!");
			}
		}

		// Cerramos el scanner
		scanner.close();
	}

	// Función que desordena el array
	public static char[] desordena(char[] t) {
		Random rand = new Random();
		char temp;

		// Algoritmo de Fisher-Yates para barajar el array
		for (int i = t.length - 1; i > 0; i--) {
			int j = rand.nextInt(i + 1);

			// Intercambiar t[i] con t[j]
			temp = t[i];
			t[i] = t[j];
			t[j] = temp;
		}
		return t;
	}
}
