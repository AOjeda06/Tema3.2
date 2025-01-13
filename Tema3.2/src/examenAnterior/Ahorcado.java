package examenAnterior;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

	static String[] palabras = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza",
			"brazo", "familia" };
	static int numintentos = 7;
	static String palabraSecreta = "";
	static StringBuilder palabraPista;
	static String noAcertadas = "";
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		generaPalabra();
		palabraPista = new StringBuilder(palabraSecreta.length());
		for (int i = 0; i < palabraSecreta.length(); i++) {
			palabraPista.append('_');
		}

		pintaPista();
		int ans;
		String answer;
		while (!palabraPista.toString().equalsIgnoreCase(palabraSecreta) && numintentos > 0) {
			System.out.println();
			do {
				ans = menu();
			} while (ans != 1 && ans != 2);

			switch (ans) {
			case 1 -> {
				System.out.println("Introduce la letra: ");
				answer = scanner.next();
				compruebaLetra(answer.charAt(0));
			}
			case 2 -> {
				System.out.println("Introduce la palabra: ");
				answer = scanner.next();
				compruebaPalabra(answer);
			}
			default -> System.out.println("Opción no válida");
			}

			pintaPista();
			System.out.println("Intentos restantes: " + numintentos);
		}
		if (numintentos > 0) {
			System.out.println("WINNER");
		} else {
			System.out.println("LOSER");
		}

		scanner.close();
	}

	public static void generaPalabra() {
		Random rand = new Random();
		int random = rand.nextInt(palabras.length);
		palabraSecreta = palabras[random];
	}

	public static int menu() {
		int ans;
		System.out.println("Seleccione una de las siguientes opciones: ");
		System.out.println("1. Introducir letra");
		System.out.println("2. Introducir palabra");
		ans = scanner.nextInt();
		return ans;
	}

	public static void compruebaLetra(char letra) {
		int index = palabraSecreta.indexOf(letra);
		boolean letraEncontrada = false;

		while (index >= 0) {
			palabraPista.setCharAt(index, letra);
			index = palabraSecreta.indexOf(letra, index + 1);
			letraEncontrada = true;
		}

		if (!letraEncontrada) {
			if (noAcertadas.indexOf(letra) < 0) {
				noAcertadas += letra + " ";
				numintentos--;
			}
		}
	}

	public static void compruebaPalabra(String palabra) {
		if (palabra.equalsIgnoreCase(palabraSecreta)) {
			palabraPista = new StringBuilder(palabraSecreta);
		} else {
			numintentos--;
		}
	}

	public static void pintaPista() {
		System.out.println("Letras no acertadas: " + noAcertadas);
		for (int i = 0; i < palabraPista.length(); i++) {
			System.out.print(palabraPista.charAt(i) + " ");
		}
		System.out.println();
	}
}
