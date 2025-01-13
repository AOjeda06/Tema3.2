package examenAnterior;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

	// Array de palabras posibles para el juego
	static String[] palabras = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza",
			"brazo", "familia" };
	// Número máximo de intentos que tiene el jugador
	static int numintentos = 7;
	// Palabra que el jugador tiene que adivinar
	static String palabraSecreta = "";
	// Pista que muestra las letras acertadas y guiones bajos para las letras no
	// acertadas
	static StringBuilder palabraPista;
	// Cadena que almacena las letras que el jugador ha intentado pero no están en
	// la palabra secreta
	static String noAcertadas = "";
	// Escáner para leer la entrada del usuario
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Generar una palabra aleatoria para la palabra secreta
		generaPalabra();

		// Inicializar la pista con guiones bajos
		palabraPista = new StringBuilder(palabraSecreta.length());
		for (int i = 0; i < palabraSecreta.length(); i++) {
			palabraPista.append('_');
		}

		// Mostrar la pista inicial
		pintaPista();

		// Variables para la opción seleccionada y la entrada del usuario
		int ans;
		String answer;

		// Bucle principal del juego: continuar hasta que se adivine la palabra o se
		// agoten los intentos
		while (!palabraPista.toString().equalsIgnoreCase(palabraSecreta) && numintentos > 0) {
			System.out.println(); // Salto de línea para separar las iteraciones

			// Mostrar el menú y leer la opción seleccionada hasta que sea válida
			do {
				ans = menu();
			} while (ans != 1 && ans != 2);

			// Procesar la opción seleccionada
			switch (ans) {
			case 1 -> {
				// Opción 1: el jugador introduce una letra
				System.out.println("Introduce la letra: ");
				answer = scanner.next();
				compruebaLetra(answer.charAt(0));
			}
			case 2 -> {
				// Opción 2: el jugador introduce una palabra
				System.out.println("Introduce la palabra: ");
				answer = scanner.next();
				compruebaPalabra(answer);
			}
			default -> System.out.println("Opción no válida");
			}

			// Mostrar la pista actualizada y el número de intentos restantes
			pintaPista();
			System.out.println("Intentos restantes: " + numintentos);
		}

		// Mostrar el resultado del juego
		if (numintentos > 0) {
			System.out.println("WINNER");
		} else {
			System.out.println("LOSER");
		}

		// Cerrar el escáner
		scanner.close();
	}

	// Generar una palabra aleatoria para la palabra secreta
	public static void generaPalabra() {
		Random rand = new Random();
		int random = rand.nextInt(palabras.length);
		palabraSecreta = palabras[random];
	}

	// Mostrar el menú y devolver la opción seleccionada
	public static int menu() {
		int ans;
		System.out.println("Seleccione una de las siguientes opciones: ");
		System.out.println("1. Introducir letra");
		System.out.println("2. Introducir palabra");
		ans = scanner.nextInt();
		return ans;
	}

	// Comprobar si la letra está en la palabra secreta
	public static void compruebaLetra(char letra) {
		int index = palabraSecreta.indexOf(letra);
		boolean letraEncontrada = false;

		// Buscar todas las ocurrencias de la letra en la palabra secreta
		while (index >= 0) {
			palabraPista.setCharAt(index, letra); // Actualizar la pista con la letra acertada
			index = palabraSecreta.indexOf(letra, index + 1); // Buscar la siguiente ocurrencia
			letraEncontrada = true;
		}

		// Si la letra no se encontró, añadirla a noAcertadas y decrementar el número de
		// intentos
		if (!letraEncontrada) {
			if (noAcertadas.indexOf(letra) < 0) {
				noAcertadas += letra + " ";
				numintentos--;
			}
		}
	}

	// Comprobar si la palabra introducida es correcta
	public static void compruebaPalabra(String palabra) {
		if (palabra.equalsIgnoreCase(palabraSecreta)) {
			palabraPista = new StringBuilder(palabraSecreta); // Actualizar la pista con la palabra acertada
		} else {
			numintentos--; // Decrementar el número de intentos si la palabra es incorrecta
		}
	}

	// Mostrar la pista y las letras no acertadas
	public static void pintaPista() {
		System.out.println("Letras no acertadas: " + noAcertadas);
		for (int i = 0; i < palabraPista.length(); i++) {
			System.out.print(palabraPista.charAt(i) + " ");
		}
		System.out.println();
	}
}
