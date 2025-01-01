package com.alessandragodoy.literalura.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Represents the data structure for the data results obtained.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos (
		@JsonAlias("results")List<DatosLibro> resultados
		){

}
