package com.alessandragodoy.literalura.repository;

import com.alessandragodoy.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing {@link Autor} entities.
 */
public interface AutorRepository extends JpaRepository<Autor, Long> {

    /**
     * Finds authors who were alive during a specified period.
     *
     * @param periodo the period to check against the authors' birth and death dates
     * @return an {@link Optional} containing a list of authors who were alive during the specified period
     */
    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :periodo AND (a.fechaDeFallecimiento > :periodo OR a.fechaDeFallecimiento IS NULL)")
    Optional<List<Autor>> findAutoresVivosPorPeriodo(@Param("periodo") int periodo);

}
