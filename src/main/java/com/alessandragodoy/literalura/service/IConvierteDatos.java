package com.alessandragodoy.literalura.service;

public interface IConvierteDatos {

	<T> T convertirDatos(String json, Class<T> clase);
}
