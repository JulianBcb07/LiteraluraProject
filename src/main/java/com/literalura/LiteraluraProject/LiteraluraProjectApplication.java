package com.literalura.LiteraluraProject;

import com.literalura.LiteraluraProject.main.Main;
import com.literalura.LiteraluraProject.repository.AutorRepository;
import com.literalura.LiteraluraProject.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraProjectApplication implements CommandLineRunner {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraProjectApplication.class, args);

	}

    @Override
    public void run(String... args) throws Exception {
        Main principal = new Main(libroRepository, autorRepository);
        principal.muestraElMenu();
    }

}
