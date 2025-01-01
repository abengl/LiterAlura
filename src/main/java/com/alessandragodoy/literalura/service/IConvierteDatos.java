package com.alessandragodoy.literalura.service;

/**
 * Interface for converting JSON data to Java objects.
 */
public interface IConvierteDatos {

	<T> T convertirDatos(String json, Class<T> clase);
}
