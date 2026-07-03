package _BitsSinExito.ExamenFinal.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contactos")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@Tag(name = "Contacto", description = "API para gestionar contactos de AAPOS")
public class ContactoController {

    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los contactos")
    public List<Contacto> obtenerTodos() {
        return contactoService.obtenerTodos();
    }

    @PostMapping
    @Operation(summary = "Agregar un nuevo contacto")
    public Contacto agregar(@RequestBody Contacto contacto) {
        return contactoService.agregar(contacto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un contacto existente")
    public Contacto actualizar(@PathVariable Long id, @RequestBody Contacto contacto) {
        return contactoService.actualizar(id, contacto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un contacto")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = contactoService.eliminar(id);
        return eliminado ? "Contacto eliminado" : "Contacto no encontrado";
    }
}