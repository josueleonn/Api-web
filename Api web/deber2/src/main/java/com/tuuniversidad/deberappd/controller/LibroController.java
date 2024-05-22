package com.tuuniversidad.deberappd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuuniversidad.deberappd.models.Libro;
import com.tuuniversidad.deberappd.service.LibroService;

@RestController
@RequestMapping("/Todos")
public class LibroController {

    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodosLosLibros() {
        List<Libro> libros = libroService.obtenerTodosLosLibros();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
        Optional<Libro> libro = libroService.obtenerLibroPorId(id);
        if (libro.isPresent()) {
            return ResponseEntity.ok(libro.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
    @PostMapping
    public ResponseEntity<String> crearLibro(@RequestBody Libro libro) {
        libroService.agregarLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("se ingreso el libro correctamente.");
    }
}
