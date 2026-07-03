package _BitsSinExito.ExamenFinal.service;

import _BitsSinExito.ExamenFinal.model.Requisito;
import _BitsSinExito.ExamenFinal.repository.RequisitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RequisitoService {

    @Autowired
    private RequisitoRepository requisitoRepository;

    public List<Requisito> listarTodos() {
        return requisitoRepository.findAll();
    }

    public List<Requisito> buscarPorServicio(Long servicioId) {
        return requisitoRepository.findByServicioIdOrderByOrdenAsc(servicioId);
    }

    // NUEVO: Obtener un único requisito por su ID
    public Requisito buscarPorId(Long id) {
        return requisitoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requisito no encontrado con ID: " + id));
    }

    public Requisito guardar(Requisito requisito) {
        return requisitoRepository.save(requisito);
    }

    public Requisito actualizar(Long id, Requisito requisitoActualizado) {
        return requisitoRepository.findById(id).map(requisito -> {
            // Actualizamos solo los campos permitidos
            requisito.setRequisito(requisitoActualizado.getRequisito());
            requisito.setObligatorio(requisitoActualizado.getObligatorio());
            requisito.setDescripcion(requisitoActualizado.getDescripcion());
            requisito.setOrden(requisitoActualizado.getOrden());
            requisito.setEstado(requisitoActualizado.getEstado());

            return requisitoRepository.save(requisito);
        }).orElseThrow(() -> new RuntimeException("Requisito no encontrado con ID: " + id));
    }

    public void eliminar(Long id) {
        requisitoRepository.deleteById(id);
    }
}