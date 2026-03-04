package com.literalura.LiteraluraProject.repository;

import com.literalura.LiteraluraProject.model.Autor;
import com.literalura.LiteraluraProject.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
