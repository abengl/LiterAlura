package com.alessandragodoy.literalura.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents the data structure for an author.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
		@JsonAlias("name") String nombre,
		@JsonAlias("birth_year") String fechaDeNacimiento,
		@JsonAlias("death_year") String fechaDeFallecimiento
) {
}
