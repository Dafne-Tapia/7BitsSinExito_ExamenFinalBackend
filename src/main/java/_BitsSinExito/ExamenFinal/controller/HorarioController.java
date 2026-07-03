package _BitsSinExito.ExamenFinal.controller;

import _BitsSinExito.ExamenFinal.model.Horario;
import _BitsSinExito.ExamenFinal.service.HorarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
@Tag(name = "Horarios", description = "Operaciones CRUD sobre los horarios de atención")
public class HorarioController {

    private final HorarioService horarioService;

    @Autowired
    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los horarios")
    public ResponseEntity<List<Horario>> obtenerTodos() {
        return ResponseEntity.ok(horarioService.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un horario por su id")
    public ResponseEntity<Horario> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(horarioService.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo horario")
    public ResponseEntity<Horario> crear(@RequestBody Horario horario) {
        Horario nuevo = horarioService.crear(horario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un horario existente")
    public ResponseEntity<Horario> actualizar(@PathVariable Long id, @RequestBody Horario horario) {
        return ResponseEntity.ok(horarioService.actualizar(id, horario));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un horario")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        horarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}