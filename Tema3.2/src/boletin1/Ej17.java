package boletin1;

public class Ej17 {

	public static void main(String[] args) {
		// String de prueba
		String codigo = "if (a==3) /* igual a tres */ a++; /* incrementamos a */";

		// Imprimimos el antes
		System.out.println("Entrada: " + codigo);
		// Llamamos a la funcion
		String codigoSinComentarios = eliminarComentarios(codigo);
		// Imprimimos el despues
		System.out.println("Salida: " + codigoSinComentarios);
	}

	public static String eliminarComentarios(String codigo) {
		// Convertimos la sentencia recibida en un array de Char
		char[] chars = codigo.toCharArray();
		// Creamos un array para la frase final con la misma longitud que el de
		// caracteres
		char[] resultado = new char[chars.length];
		// Booleano para controlar cuando lo que está recorriendo el bucle está dentro o
		// fuera de un comentario
		boolean enComentario = false;
		// Índice para el array resultado, utilizado para almacenar caracteres que no
		// son parte de comentarios.
		int index = 0;

		for (int i = 0; i < chars.length; i++) {
			if (i < chars.length - 1 && chars[i] == '/' && chars[i + 1] == '*') {
				enComentario = true;
				i++; // Saltar el '*' después de '/'
			} else if (enComentario && i < chars.length - 1 && chars[i] == '*' && chars[i + 1] == '/') {
				enComentario = false;
				i++; // Saltar el '/' después de '*'
			} else if (!enComentario) {
				// Si no estamos dentro de un comentario copiamos el caracter actual al array
				// resultado
				resultado[index++] = chars[i];
				// Asigna el caracter y aumenta el index para seguir por donde lo dejamos en el
				// ultimo caracter
			}
		}

		// Creamos una cadena, usando el string resultado, hasta la posicion 'index'
		return new String(resultado, 0, index);
	}
}
