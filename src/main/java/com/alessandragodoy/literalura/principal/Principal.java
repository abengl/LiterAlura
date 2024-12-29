package com.alessandragodoy.literalura.principal;

import com.alessandragodoy.literalura.model.Datos;
import com.alessandragodoy.literalura.service.ConsumoAPI;
import com.alessandragodoy.literalura.service.ConvierteDatos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	private final Scanner input = new Scanner(System.in);
	private final ConsumoAPI consumoAPI = new ConsumoAPI();
	private final ConvierteDatos conversor = new ConvierteDatos();
	private static final String URL = "https://gutendex.com/books/";

	public void testing() {
		var json = consumoAPI.obtenerDatos(URL + "?search=pride%20and%20prejudice");

		System.out.println("Testing API");
		System.out.println(json);

		var datos = conversor.convertirDatos(json, Datos.class);
		System.out.println("Testing conversion");
		System.out.println(datos);
	}

	public void muestraElMenu() {
		System.out.println("\n--------------- Literalura ---------------");
		System.out.println(">>> Escribe el número de la opción a realizar: ");
		var opcion = -1;
		while (opcion != 0) {
			var menu = """
					1 - Buscar libro por título
					2 - Listar libros registrados
					3 - Listar autores registrados
					4 - Listar autores vivos en un determinado año
					5 - Listar libro por idioma
					0 - Salir
					""";
			System.out.println(menu);

			try {
				opcion = input.nextInt();
				input.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(">>> Ingrese un número válido.\n");
				input.nextLine();
				continue;
			}

			switch (opcion) {
				case 1:
					buscarLibroPorTitulo();
					break;
				case 2:
					listarLibrosRegistrados();
					break;
				case 3:
					listarAutoresRegistrados();
					break;
				case 4:
					listarAutoresVivosPorPeriodo();
					break;
				case 5:
					listarLibroPorIdioma();
					break;
				case 0:
					System.out.println(">>> Cerrando LiterAlura... ¡Adiós!\n");
					break;
				default:
					System.out.println(">>> Opción inválida.\n");
			}

		}
	}

	private void buscarLibroPorTitulo() {
		System.out.println("1");
	}

	private void listarLibrosRegistrados() {
		System.out.println("2");
	}

	private void listarAutoresRegistrados() {
		System.out.println("3");
	}

	private void listarAutoresVivosPorPeriodo() {
		System.out.println("4");
	}

	private void listarLibroPorIdioma() {
		System.out.println("5");
	}
}
