package boletin1;

import java.util.Scanner;

public class Ej18 {

	public static void main(String[] args) {
		// Configuramos el scanner
		Scanner scanner = new Scanner(System.in);

		// Variables
		String titulo;
		String contenido;

		// Obtiene el contenido del titulo
		System.out.println("Dime el titulo de tu pagina web");
		titulo = scanner.nextLine();

		// Obtiene el contenido
		System.out.println("Dime el contenido de tu página web: ");
		contenido = scanner.nextLine();

		scanner.close();

		// Impresion final
		System.out.println("<!DOCTYPE html>");
		System.out.println("<html>");
		System.out.println("<head>");
		System.out.println("\t <meta charset=\"utf-8\">");
		System.out.println("\t <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		System.out.println("\t <title>Pagina creada con Eclipseee</title>");
		System.out.println("</head>");
		System.out.println("<body>");
		System.out.println("\t <h1>" + titulo + "</h1>");
		System.out.println("\t <p>" + contenido + "</p>");
		System.out.println("</body>");
		System.out.println("</html>");
	}

}
