package com.alessandragodoy.literalura.service;

import com.alessandragodoy.literalura.exception.RecursoNoEncontradoException;
import com.alessandragodoy.literalura.model.Autor;
import com.alessandragodoy.literalura.model.Libro;
import com.alessandragodoy.literalura.model.dto.Datos;
import com.alessandragodoy.literalura.repository.AutorRepository;
import com.alessandragodoy.literalura.repository.LibroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing books and authors.
 */
@Service
@RequiredArgsConstructor
public class LibroService {
	private final LibroRepository libroRepository;
	private final AutorRepository autorRepository;

	@Transactional
	public void buscarLibroPorTitulo(Datos datos) {
		datos.resultados().stream()
				.findFirst()
				.map(d -> {
					Autor autor = new Autor(d.autores().get(0));
					autor = autorRepository.save(autor);
					Libro libro = new Libro(d);
					libro.setAutor(autor);
					return libro;
				})
				.ifPresentOrElse(
						libro -> System.out.println(libroRepository.save(libro)),
						() -> System.out.println(">>> Libro no encontrado.")
				);
	}

	public List<Libro> listarLibros() {
		return libroRepository.findAll();
	}

	public List<Autor> listarAutores() {
		return autorRepository.findAll();
	}

	public List<Autor> listarAutoresVivosEnPeriodo(int periodo) {
		return autorRepository.findAutoresVivosPorPeriodo(periodo).orElseThrow(() -> new RecursoNoEncontradoException(
				" >>> No se encontraron autores registrados en ese periodo."));
	}

	public List<Libro> listarLibrosPorIdioma(String idioma) {
		return libroRepository.findByIdiomaIgnoreCase(idioma).orElseThrow(
				() -> new RecursoNoEncontradoException(">>> No se encontraron libros registrados para ese idioma."));
	}
}
