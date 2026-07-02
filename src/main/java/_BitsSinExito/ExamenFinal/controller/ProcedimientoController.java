package _BitsSinExito.ExamenFinal.controller;

import _BitsSinExito.ExamenFinal.model.Procedimiento;
import _BitsSinExito.ExamenFinal.service.ProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/procedimientos")
public class ProcedimientoController {

    @Autowired
    private ProcedimientoService procedimientoService;

    @GetMapping
    public List<Procedimiento> listarTodos() {
        return procedimientoService.listarTodos();
    }

    @GetMapping("/servicio/{servicioId}")
    public List<Procedimiento> listarPorServicio(@PathVariable Long servicioId) {
        return procedimientoService.listarPorServicio(servicioId);
    }
}