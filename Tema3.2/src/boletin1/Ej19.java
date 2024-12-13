package boletin1;

public class Ej19 {

	public static void main(String[] args) {
		// String que usamos de ejemplo de entrada
		String frase = "Me GUsta merenDAR gaLLEtas";
		// Llamamos a la funcion
		String camelCase = convertirACamelCase(frase);
		// Imprimimos el antes y el después
		System.out.println("Entrada: " + frase);
		System.out.println("Salida: " + camelCase);
	}

	public static String convertirACamelCase(String frase) {
		// Dividimos la frase en un array, usando los espacios como separadores
		String[] palabras = frase.split(" ");
		// Inicializamos una variable para almacenar la frase en nomenclatura camelcase
		String camelCase = "";

		for (int i = 0; i < palabras.length; i++) {
			// Convertimos la palabra actual a minusculas
			String palabra = palabras[i].toLowerCase();
			// Si es la primera palabra se añade en minúsculas
			if (i == 0) {
				camelCase += palabra;
			} else {
				// Convertimos el primer carácter a mayúsculas y le añadimos el resto (que está
				// en minúsculas)
				camelCase += Character.toUpperCase(palabra.charAt(0)) + palabra.substring(1);
			}
		}

		// Devolvemos la frase en nomenclatura camelcase
		return camelCase;
	}
}
