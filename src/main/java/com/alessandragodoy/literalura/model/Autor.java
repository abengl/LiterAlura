package com.alessandragodoy.literalura.model;

import com.alessandragodoy.literalura.model.dto.DatosAutor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an author with their personal details.
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "autor")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String fechaDeNacimiento;

	private String fechaDeFallecimiento;

	public Autor(DatosAutor autor) {
		this.nombre = autor.nombre();
		this.fechaDeNacimiento = autor.fechaDeNacimiento();
		this.fechaDeFallecimiento = autor.fechaDeFallecimiento();
	}

	@Override
	public String toString() {
		return nombre + " (" + fechaDeNacimiento + " - " + fechaDeFallecimiento + ")";
	}
}
