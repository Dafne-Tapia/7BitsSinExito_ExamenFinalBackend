package _BitsSinExito.ExamenFinal.controller;

import _BitsSinExito.ExamenFinal.model.Requisito;
import _BitsSinExito.ExamenFinal.service.RequisitoService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
