package boletin1;

public class Ej17v2 {

	public static void main(String[] args) {
		// String de prueba
		String codigo = "if (a==3) /* igual a tres */ a++; /* incrementamos a */";

		// Imprimimos el antes
		System.out.println("Entrada: " + codigo);
		// Llamamos a la función
		String codigoSinComentarios = eliminarComentarios(codigo);
		// Imprimimos el después
		System.out.println("Salida: " + codigoSinComentarios);
	}

	public static String eliminarComentarios(String codigo) {
		String resultado = "";
		int i = 0;
		int finComentario = 0;

		while ((i = codigo.indexOf("/*")) >= 0) {
			// Añadir la parte del código antes del comentario
			resultado += codigo.substring(0, i);
			// Encontrar el final del comentario
			finComentario = codigo.indexOf("*/");
			// Actualizar el índice a después del comentario
			i = finComentario + 2;
			// Continuar desde el final del comentario
			codigo = codigo.substring(i);
		}

		return resultado;
	}
}
