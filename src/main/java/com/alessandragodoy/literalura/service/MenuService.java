package com.alessandragodoy.literalura.service;

import com.alessandragodoy.literalura.exception.RecursoNoEncontradoException;
import com.alessandragodoy.literalura.model.dto.Datos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Service class for displaying and managing the menu options.
 */
@RequiredArgsConstructor
@Service
public class MenuService {
	private final LibroService libroService;

	private String URL = "https://gutendex.com/books/";
	private ConsumoAPI consumoAPI = new ConsumoAPI();
	private ConvierteDatos conversor = new ConvierteDatos();

	public void mostrarMenu() {
		var opcion = -1;
		var input = new Scanner(System.in);

		while (opcion != 0) {
			System.out.println("\n--------------- Literalura ---------------");
			System.out.println(">>> Escribe el número de la opción a realizar: ");
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
				ejecutarOpcion(opcion, input);
			} catch (InputMismatchException e) {
				System.out.println(">>> Ingrese un número válido.\n");
				input.nextLine();
			}
		}
	}

	private void ejecutarOpcion(int opcion, Scanner input) {
		switch (opcion) {
			case 1 -> buscarLibroPorTitulo(input);
			case 2 -> listarLibrosRegistrados();
			case 3 -> listarAutoresRegistrados();
			case 4 -> listarAutoresVivosPorPeriodo(input);
			case 5 -> listarLibroPorIdioma(input);
			case 0 -> System.out.println(">>> Cerrando LiterAlura... ¡Adiós!\n");
			default -> System.out.println(">>> Opción inválida.\n");
		}
	}

	private void buscarLibroPorTitulo(Scanner input) {
		System.out.println(">>> Escribe el título del libro a buscar: ");
		var tituloLibro = input.nextLine();

		var json = consumoAPI.obtenerDatos(URL + "?search=" + tituloLibro.replace(" ", "%20"));
		var libros = conversor.convertirDatos(json, Datos.class);

		libroService.buscarLibroPorTitulo(libros);
	}

	private void listarLibrosRegistrados() {
		libroService.listarLibros().forEach(System.out::println);
	}

	private void listarAutoresRegistrados() {
		libroService.listarAutores().forEach(System.out::println);
	}

	private void listarAutoresVivosPorPeriodo(Scanner input) {
		try {
			System.out.println(">>> Ingrese el año: ");
			var periodo = input.nextInt();
			input.nextLine();
			libroService.listarAutoresVivosEnPeriodo(periodo).forEach(System.out::println);
		} catch (RecursoNoEncontradoException e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarLibroPorIdioma(Scanner input) {
		try {
			System.out.println(">>> Ingrese el idioma: ");
			var idioma = input.nextLine();
			libroService.listarLibrosPorIdioma(idioma).forEach(System.out::println);
		} catch (RecursoNoEncontradoException e) {
			System.out.println(e.getMessage());
		}
	}
}
