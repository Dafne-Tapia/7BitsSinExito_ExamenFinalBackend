package _BitsSinExito.ExamenFinal.controller;

import _BitsSinExito.ExamenFinal.model.Documento;
import _BitsSinExito.ExamenFinal.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public ResponseEntity<List<Documento>> listarTodos() {
        return ResponseEntity.ok(documentoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> obtenerPorId(@PathVariable Long id) {
        return documentoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/servicio/{servicioId}")
    public ResponseEntity<List<Documento>> obtenerPorServicio(@PathVariable Long servicioId) {
        return ResponseEntity.ok(documentoService.obtenerPorServicioId(servicioId));
    }

    @PostMapping
    public ResponseEntity<Documento> crear(@RequestBody Documento documento) {
        return ResponseEntity.ok(documentoService.guardar(documento));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Documento> actualizar(@PathVariable Long id, @RequestBody Documento documento) {
        return ResponseEntity.ok(documentoService.actualizar(id, documento));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        documentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

