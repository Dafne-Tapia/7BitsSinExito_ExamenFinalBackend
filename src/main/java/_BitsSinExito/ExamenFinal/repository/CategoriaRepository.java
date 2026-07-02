package com.example.ProyectoSis414.controller;

import com.example.ProyectoSis414.model.CategoriaServicio;
import com.example.ProyectoSis414.service.CategoriaServicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias-servicios")
@CrossOrigin(origins = "*")
public class CategoriaServicioController {

    private final CategoriaServicioService categoriaServicioService;

    public CategoriaServicioController(CategoriaServicioService categoriaServicioService) {
        this.categoriaServicioService = categoriaServicioService;
    }

    @GetMapping
    public List<CategoriaServicio> obtenerTodos() {
        return categoriaServicioService.obtenerTodos();
    }

    @PostMapping
    public CategoriaServicio agregar(@RequestBody CategoriaServicio categoriaServicio) {
        return categoriaServicioService.agregar(categoriaServicio);
    }

    @PutMapping("/{id}")
    public CategoriaServicio actualizar(@PathVariable Long id, @RequestBody CategoriaServicio categoriaServicio) {
        return categoriaServicioService.actualizar(id, categoriaServicio);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = categoriaServicioService.eliminar(id);
        return eliminado ? "Categoria eliminada" : "Categoria no encontrada";
    }
}