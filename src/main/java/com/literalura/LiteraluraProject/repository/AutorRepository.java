package com.literalura.LiteraluraProject.repository;

import com.literalura.LiteraluraProject.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombreIgnoreCase(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento <= :year AND (a.fechaFallecimiento > :year OR a.fechaFallecimiento IS NULL)")
    List<Autor> buscarAutoresvivos(String year);
}
