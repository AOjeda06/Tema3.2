package boletin1;

public class Ej17v2 {

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
		String resultado = "";
		int longitud = codigo.length();
		int i = 0;
		while (i < longitud) {
			// Utiliza substring para extraer una subcadena de dos caracteres a partir del
			// índice i y compara si es igual a /*. Si es así, hemos detectado el inicio de
			// un comentario
			if (i < longitud - 1 && codigo.substring(i, i + 2).equals("/*")) {
				// Busca la posición del final del comentario (*/) comenzando desde el índice i
				// + 2. Ajusta el índice i para que apunte al carácter justo después de */.
				i = codigo.indexOf("*/", i + 2) + 2;
			} else {
				// Añadir el carácter actual a la cadena resultado
				resultado += codigo.charAt(i);
				i++;
			}
		}
		return resultado;
	}
}
