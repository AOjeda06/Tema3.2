package examenAnterior;

import java.util.Random;

public class Criptograma {

	// Array bidimensional con las letras del abecedario español
	static char[][] abecedario = { { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' },
			{ 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q' }, { 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' } };

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
		desordenaAbecedario();
	}

	public static void desordenaAbecedario() {
		// Declarar todas las variables al inicio de la función
		int filas = abecedario.length;
		int columnas = abecedario[0].length;
		int i, j, row1, col1, row2, col2;
		char temp;

		// Iterar desde el último índice hasta el primero en un array unidimensional
		// imaginario
		for (i = filas * columnas - 1; i > 0; i--) {
			// Generar un índice aleatorio entre 0 e i (inclusive)
			j = random.nextInt(i + 1);

			// Convertir el índice unidimensional 'i' a índices bidimensionales 'row1' y
			// 'col1'
			row1 = i / columnas;
			col1 = i % columnas;

			// Convertir el índice unidimensional 'j' a índices bidimensionales 'row2' y
			// 'col2'
			row2 = j / columnas;
			col2 = j % columnas;

			// Intercambiar los elementos en las posiciones (row1, col1) y (row2, col2) del
			// array abecedario
			temp = abecedario[row1][col1];
			abecedario[row1][col1] = abecedario[row2][col2];
			abecedario[row2][col2] = temp;
		}
	}

	public static void eligeFrase() {
		fraseReal = frases[random.nextInt(frases.length)];
	}

	public static void codificaFrase() {
		for (int k = 0; k < fraseReal.length(); k++) {
			for (int i = 0; i < abecedario.length; i++) {
				for (int j = 0; j < abecedario[0].length; j++) {
					if (fraseReal.charAt(k) == abecedario[i][j]) {
						fraseCodificada += i;
						fraseCodificada += j;
						fraseCodificada += " ";
					} else {
						fraseCodificada += "  ";
					}
				}
			}
		}
	}

	public static boolean compruebaCodigo(String num, char letra) {
		boolean correcto = false;
		if (letra == abecedario[num.charAt(0)][num.charAt(1)]) {
			correcto = true;
		}

		return correcto;
	}

}
