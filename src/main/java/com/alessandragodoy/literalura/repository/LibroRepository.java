package com.alessandragodoy.literalura.repository;

import com.alessandragodoy.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing {@link Libro} entities.
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    /**
     * Finds books by their language, ignoring case.
     *
     * @param idioma the language of the books to find
     * @return an {@link Optional} containing a list of books with the specified language
     */
    Optional<List<Libro>> findByIdiomaIgnoreCase(String idioma);
}