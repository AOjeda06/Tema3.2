package examenAnterior;

import java.util.Random;
import java.util.Scanner;

public class Criptograma {

	// Array bidimensional con las letras del abecedario español
	static char[][] abecedario = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	// Array unidimensional con las frases para el criptograma
	static String[] frases = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };

	// Variables para la frase real y la frase codificada
	static String fraseReal;
	static String fraseCodificada;
	static Random random = new Random();

	public static void main(String[] args) {
		// Desordenar el array del abecedario
		desordenaAbecedario();
		// Elegir una frase aleatoria
		eligeFrase();
		// Codificar la frase elegida
		codificaFrase();

		// Crear un escáner para leer la entrada del usuario
		Scanner scanner = new Scanner(System.in);

		// Bucle principal del juego: continuar hasta que las frases coincidan
		while (!sonIguales()) {
			// Mostrar la frase codificada
			System.out.println("Frase codificada: " + fraseCodificada);
			// Pedir al usuario que introduzca un código
			System.out.print("Introduce un código (e.g., 01): ");
			String codigo = scanner.next();
			// Pedir al usuario que introduzca una letra
			System.out.print("Introduce una letra: ");
			char letra = scanner.next().charAt(0);

			// Comprobar si el código introducido corresponde a la letra indicada
			if (compruebaCodigo(codigo, letra)) {
				System.out.println("¡Correcto!");
			} else {
				System.out.println("Incorrecto. Inténtalo de nuevo.");
			}
		}

		// Felicitar al jugador una vez haya acertado la frase
		System.out.println("¡¡ENHORABUENA!! HAS ACERTADO");

		// Cerrar el escáner
		scanner.close();
	}

	public static void desordenaAbecedario() {
		// Obtener las dimensiones del array
		int filas = abecedario.length;
		int columnas = abecedario[0].length;
		int i, j, row1, col1, row2, col2;
		char temp;

		// Desordenar el array utilizando el algoritmo de Fisher-Yates adaptado a 2D
		for (i = filas * columnas - 1; i > 0; i--) {
			j = random.nextInt(i + 1);

			// Convertir el índice unidimensional 'i' a índices bidimensionales 'row1' y
			// 'col1'
			row1 = i / columnas;
			col1 = i % columnas;

			// Convertir el índice unidimensional 'j' a índices bidimensionales 'row2' y
			// 'col2'
			row2 = j / columnas;
			col2 = j % columnas;

			// Intercambiar los elementos en las posiciones (row1, col1) y (row2, col2)
			temp = abecedario[row1][col1];
			abecedario[row1][col1] = abecedario[row2][col2];
			abecedario[row2][col2] = temp;
		}
	}

	public static void eligeFrase() {
		// Seleccionar una frase aleatoria del array 'frases'
		fraseReal = frases[random.nextInt(frases.length)];
	}

	public static void codificaFrase() {
		// Inicializar 'fraseCodificada' como cadena vacía
		fraseCodificada = "";
		// Recorrer cada carácter de 'fraseReal'
		for (int k = 0; k < fraseReal.length(); k++) {
			char letra = fraseReal.charAt(k);
			if (letra == ' ') {
				// Los espacios se representan como dos espacios en 'fraseCodificada'
				fraseCodificada += "  ";
			} else {
				boolean found = false;
				// Buscar la letra en el array 'abecedario'
				for (int i = 0; i < abecedario.length && !found; i++) {
					for (int j = 0; j < abecedario[i].length; j++) {
						if (letra == abecedario[i][j]) {
							// Añadir las coordenadas de la letra a 'fraseCodificada'
							fraseCodificada += i + "" + j + " ";
							found = true;
							break;
						}
					}
				}
			}
		}
	}

	public static boolean compruebaCodigo(String num, char letra) {
		// Convertir el código (e.g., "01") a índices de fila y columna
		int fila = Character.getNumericValue(num.charAt(0));
		int columna = Character.getNumericValue(num.charAt(1));
		// Comprobar si la letra en 'abecedario[fila][columna]' coincide con la letra
		// introducida
		if (fila < abecedario.length && columna < abecedario[0].length && abecedario[fila][columna] == letra) {
			// Reemplazar el código por la letra en 'fraseCodificada'
			String codigoCompleto = num + " ";
			fraseCodificada = fraseCodificada.replace(codigoCompleto, letra + " ");
			return true;
		}
		return false;
	}

	public static boolean sonIguales() {
		// Separar 'fraseCodificada' en partes por los espacios
		String[] codificadaArray = fraseCodificada.trim().split(" +");
		StringBuilder fraseCodificadaLimpia = new StringBuilder();
		// Quitar espacios vacíos en las partes codificadas
		for (String parte : codificadaArray) {
			if (!parte.equals("")) {
				fraseCodificadaLimpia.append(parte);
			}
		}
		// Quitar los espacios de 'fraseReal'
		String fraseRealSinEspacios = fraseReal.replace(" ", "");
		// Comprobar si las versiones limpias y sin espacios de 'fraseCodificada' y
		// 'fraseReal' son iguales
		return fraseCodificadaLimpia.toString().equalsIgnoreCase(fraseRealSinEspacios);
	}

}
