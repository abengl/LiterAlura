package com.alessandragodoy.literalura.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String idioma;

	private Double numeroDeDescargas;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private Autor autor;

	public Libro(DatosLibro libro) {
		this.titulo = libro.titulo();
		this.idioma = (!libro.idiomas().isEmpty() ? libro.idiomas().get(0) : "Desconocido");
		this.numeroDeDescargas = libro.numeroDeDescargas();
	}


	@Override
	public String toString() {
		return "\n--- DatosLibro --- " +
				"\nTitulo: " + titulo +
				"\nAutor: " + autor +
				"\nIdiomas: " + idioma +
				"\nDescargas: " + numeroDeDescargas + "\n";
	}
}
