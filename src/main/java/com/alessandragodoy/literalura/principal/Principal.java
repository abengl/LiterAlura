package com.alessandragodoy.literalura.principal;

import com.alessandragodoy.literalura.model.Datos;
import com.alessandragodoy.literalura.service.ConsumoAPI;
import com.alessandragodoy.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {
	private Scanner input = new Scanner(System.in);
	private ConsumoAPI consumoAPI = new ConsumoAPI();
	private ConvierteDatos conversor = new ConvierteDatos();
	private final String URL = "https://gutendex.com/books/";

	public void muestraElMenu() {
		var json = consumoAPI.obtenerDatos(URL + "?search=pride%20and%20prejudice");

		System.out.println("Testing API");
		System.out.println(json);

		var datos = conversor.convertirDatos(json, Datos.class);
		System.out.println("Testing conversion");
		System.out.println(datos);
	}
}
