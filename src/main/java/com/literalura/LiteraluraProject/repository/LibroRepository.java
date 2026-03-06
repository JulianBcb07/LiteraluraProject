package com.literalura.LiteraluraProject.repository;

import com.literalura.LiteraluraProject.model.Autor;
import com.literalura.LiteraluraProject.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloIgnoreCase(String titulo);

    // JPQL:
    @Query("SELECT l FROM Libro l")
    List<Libro> listarLibros();

}
