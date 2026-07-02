package _BitsSinExito.ExamenFinal.controller;

import _BitsSinExito.ExamenFinal.model.Servicio;
import _BitsSinExito.ExamenFinal.service.ServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@Tag(name = "Servicios", description = "Operaciones CRUD sobre los servicios")
public class ServicioController {

    private final ServicioService servicioService;

    @Autowired
    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los servicios")
    public ResponseEntity<List<Servicio>> obtenerTodos() {
        return ResponseEntity.ok(servicioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un servicio por su id")
    public ResponseEntity<Servicio> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicioService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo servicio")
    public ResponseEntity<Servicio> crear(@RequestBody Servicio servicio) {
        Servicio nuevo = servicioService.crear(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un servicio existente")
    public ResponseEntity<Servicio> actualizar(@PathVariable Long id, @RequestBody Servicio servicio) {
        return ResponseEntity.ok(servicioService.actualizar(id, servicio));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un servicio")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
