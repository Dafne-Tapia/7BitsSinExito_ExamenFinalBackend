package _BitsSinExito.ExamenFinal.controller;

import _BitsSinExito.ExamenFinal.model.Procedimiento;
import _BitsSinExito.ExamenFinal.service.ProcedimientoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procedimientos")
@Tag(name = "Procedimientos", description = "Operaciones CRUD sobre los procedimientos de atencion")
public class ProcedimientoController {

    private final ProcedimientoService procedimientoService;

    @Autowired
    public ProcedimientoController(ProcedimientoService procedimientoService) {
        this.procedimientoService = procedimientoService;
    }

    @GetMapping
    @Operation(summary = "Listar todos los procedimientos")
    public ResponseEntity<List<Procedimiento>> listarTodos() {
        return ResponseEntity.ok(procedimientoService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un procedimiento por su id")
    public ResponseEntity<Procedimiento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(procedimientoService.buscarPorId(id));
    }

    @GetMapping("/servicio/{servicioId}")
    @Operation(summary = "Listar procedimientos por servicio")
    public ResponseEntity<List<Procedimiento>> listarPorServicio(@PathVariable Long servicioId) {
        return ResponseEntity.ok(procedimientoService.listarPorServicio(servicioId));
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo procedimiento")
    public ResponseEntity<Procedimiento> guardar(@RequestBody Procedimiento procedimiento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(procedimientoService.guardar(procedimiento));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un procedimiento existente")
    public ResponseEntity<Procedimiento> actualizar(@PathVariable Long id,
                                                    @RequestBody Procedimiento procedimiento) {
        return ResponseEntity.ok(procedimientoService.actualizar(id, procedimiento));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un procedimiento")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        procedimientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}