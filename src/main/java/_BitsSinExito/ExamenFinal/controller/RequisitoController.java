package _BitsSinExito.ExamenFinal.controller;

import _BitsSinExito.ExamenFinal.model.Requisito;
import _BitsSinExito.ExamenFinal.service.RequisitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requisitos")
@CrossOrigin(origins = "*")
public class RequisitoController {

    @Autowired
    private RequisitoService requisitoService;

    @GetMapping
    public List<Requisito> obtenerRequisitos(@RequestParam(required = false) Long servicioId) {
        if (servicioId != null) {
            return requisitoService.buscarPorServicio(servicioId);
        }
        return requisitoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Requisito> obtenerRequisitoPorId(@PathVariable Long id) {
        try {
            Requisito requisito = requisitoService.buscarPorId(id);
            return ResponseEntity.ok(requisito);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Requisito> crearRequisito(@RequestBody Requisito requisito) {
        Requisito nuevoRequisito = requisitoService.guardar(requisito);
        return ResponseEntity.ok(nuevoRequisito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Requisito> actualizarRequisito(@PathVariable Long id, @RequestBody Requisito requisito) {
        try {
            Requisito actualizado = requisitoService.actualizar(id, requisito);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            // Si no encuentra el ID, devuelve un error 404 de forma limpia
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRequisito(@PathVariable Long id) {
        requisitoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
