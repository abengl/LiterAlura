package com.alessandragodoy.literalura.service;

import com.alessandragodoy.literalura.exception.ConsumoAPIException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * This class is responsible for consuming APIs and retrieving data as a String.
 */
public class ConsumoAPI {
	public String obtenerDatos(String url) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.build();
		HttpResponse<String> response;

		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			throw new ConsumoAPIException(e.getMessage());
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new ConsumoAPIException(e.getMessage());
		}

		return response.body();

	}
}
