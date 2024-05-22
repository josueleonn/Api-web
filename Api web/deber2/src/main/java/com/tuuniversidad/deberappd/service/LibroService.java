package com.tuuniversidad.deberappd.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuuniversidad.deberappd.models.Libro;
import com.tuuniversidad.deberappd.repository.LibroRepository;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.obtenerTodosLosLibros();
    }

    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.obtenerLibroPorId(id);
    }

    public void agregarLibro(Libro libro) {
        libroRepository.agregarLibro(libro);
    }
}
