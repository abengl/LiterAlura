package com.alessandragodoy.literalura.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Represents the data structure for a book.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
		@JsonAlias("title") String titulo,
		@JsonAlias("authors")List<DatosAutor> autores,
		@JsonAlias("languages") List<String> idiomas,
		@JsonAlias("download_count") Double numeroDeDescargas
		) {
}
