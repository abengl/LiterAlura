package com.alessandragodoy.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
		@JsonAlias("title") String titulo,
		@JsonAlias("authors")List<DatosAutor> autor,
		@JsonAlias("languages") List<String> idiomas,
		@JsonAlias("download_count") Double numeroDeDescargas
		) {

	@Override
	public String toString() {
		return "\n--- DatosLibro --- " +
				"\nTitulo: '" + titulo + '\'' +
				"\nAutor: " + autor.toString() +
				"\nIdiomas:" + idiomas +
				"\nDescargas: " + numeroDeDescargas + "\n";
	}
}
