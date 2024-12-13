package boletin1;

public class Ej20 {

	public static void main(String[] args) {
		// Palabra que vamos a meter de ejemplo
		String palabra = "destornillador";
		// Numero de secuencias en las que la vamos a dividir
		int n = 4;

		// Creamos un array de String que tiene como resultado la devolucion de la
		// funcion llamada
		String[] resultado = dividirEnSecuencias(palabra, n);

		// Imprimir el resultado
		for (String secuencia : resultado) {
			System.out.print(secuencia + " ");
		}
	}

	public static String[] dividirEnSecuencias(String palabra, int n) {
		// Creamos una variable que guarda la longitud de la palabra recibida
		int longitud = palabra.length();
		// Calculamos cuantas secuencias vamos a necesitar, redondeando hacia arriba
		// para que no queden caracteres sueltos al final
		int numSecuencias = (int) Math.ceil((double) longitud / n);
		// Creamos un array para almacenar las secuencias
		String[] secuencias = new String[numSecuencias];

		for (int i = 0; i < numSecuencias; i++) {
			// Calculamos el índice de inicio de cada secuencia multiplicando el índice del
			// bucle i por n esto asegura que las secuencias no se superpongan y comiencen
			// en el lugar correcto
			int inicio = i * n;
			// Calculamos el índice de fin de la secuencia utilizando Math.min para
			// asegurarnos de no exceder la longitud de la palabra. Esto es importante para
			// la última secuencia, que puede ser más corta que n.
			int fin = Math.min(inicio + n, longitud);
			// Utilizamos el método substring para extraer una subcadena desde inicio hasta
			// fin. Esta subcadena se almacena en el array secuencias en la posición i
			secuencias[i] = palabra.substring(inicio, fin);
		}

		// Devolvemos el array con la palabra troceada
		return secuencias;
	}
}
