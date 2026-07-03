package _BitsSinExito.ExamenFinal.controller;

import _BitsSinExito.ExamenFinal.model.Procedimiento;
import _BitsSinExito.ExamenFinal.service.ProcedimientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/procedimientos")
@CrossOrigin(origins = "*")
public class ProcedimientoController {

    private final ProcedimientoService procedimientoService;

    public ProcedimientoController(ProcedimientoService procedimientoService) {
        this.procedimientoService = procedimientoService;
    }

    @GetMapping
    public List<Procedimiento> listarTodos() {
        return procedimientoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Procedimiento buscarPorId(@PathVariable Long id) {
        return procedimientoService.buscarPorId(id);
    }

    @PostMapping
    public Procedimiento guardar(@RequestBody Procedimiento procedimiento) {
        return procedimientoService.guardar(procedimiento);
    }

    @PutMapping("/{id}")
    public Procedimiento actualizar(@PathVariable Long id,
                                    @RequestBody Procedimiento procedimiento) {
        return procedimientoService.actualizar(id, procedimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        procedimientoService.eliminar(id);
    }
}