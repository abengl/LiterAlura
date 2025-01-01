package com.alessandragodoy.literalura.repository;

import com.alessandragodoy.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
		Optional<List<Libro>> findByIdiomaIgnoreCase(String idioma);
}
