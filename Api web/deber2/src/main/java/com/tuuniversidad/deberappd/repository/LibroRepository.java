package com.tuuniversidad.deberappd.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tuuniversidad.deberappd.models.Libro;

@Repository
public class LibroRepository {

    private List<Libro> libros;

    public LibroRepository() {
        libros = new ArrayList<>();
        libros.add(new Libro(1L, "Cien años de soledad", "Gabriel García Márquez", "Editorial Sudamericana", 1967));
        libros.add(new Libro(2L, "El amor en los tiempos del cólera", "Gabriel García Márquez", "Editorial Oveja Negra", 1985));
        libros.add(new Libro(3L, "Rayuela", "Julio Cortázar", "Editorial Sudamericana", 1963));
        libros.add(new Libro(4L, "Crónica de una muerte anunciada", "Gabriel García Márquez", "Editorial La Oveja Negra", 1981));
        libros.add(new Libro(5L, "Ficciones", "Jorge Luis Borges", "Editorial Emecé", 1944));
    }

    public List<Libro> obtenerTodosLosLibros() {
        return libros;
    }

    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libros.stream().filter(libro -> libro.getId().equals(id)).findFirst();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
}
