package com.alessandragodoy.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
