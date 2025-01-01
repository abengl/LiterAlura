package com.alessandragodoy.literalura.repository;

import com.alessandragodoy.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	@Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :periodo AND (a.fechaDeFallecimiento > :periodo OR a.fechaDeFallecimiento IS NULL)")
	Optional<List<Autor>> findAutoresVivosPorPeriodo(@Param("periodo") int periodo);

}
