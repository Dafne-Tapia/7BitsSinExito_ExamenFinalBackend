package _BitsSinExito.ExamenFinal.service;

import _BitsSinExito.ExamenFinal.model.Procedimiento;
import _BitsSinExito.ExamenFinal.repository.ProcedimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimientoService {

    @Autowired
    private ProcedimientoRepository procedimientoRepository;

    public List<Procedimiento> listarTodos() {
        return procedimientoRepository.findAll();
    }

    public Procedimiento buscarPorId(Long id) {
        return procedimientoRepository.findById(id).orElse(null);
    }

    public Procedimiento guardar(Procedimiento procedimiento) {
        return procedimientoRepository.save(procedimiento);
    }

    public Procedimiento actualizar(Long id, Procedimiento procedimiento) {
        procedimiento.setId(id);
        return procedimientoRepository.save(procedimiento);
    }

    public void eliminar(Long id) {
        procedimientoRepository.deleteById(id);
    }

    public List<Procedimiento> listarPorServicio(Long servicioId) {
        return procedimientoRepository.findByServicioId(servicioId);
    }
}