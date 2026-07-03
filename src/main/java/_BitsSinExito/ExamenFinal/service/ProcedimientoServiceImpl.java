package _BitsSinExito.ExamenFinal.service;

import _BitsSinExito.ExamenFinal.model.Procedimiento;
import _BitsSinExito.ExamenFinal.repository.ProcedimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProcedimientoServiceImpl implements ProcedimientoService {

    private final ProcedimientoRepository procedimientoRepository;

    @Autowired
    public ProcedimientoServiceImpl(ProcedimientoRepository procedimientoRepository) {
        this.procedimientoRepository = procedimientoRepository;
    }

    @Override
    public List<Procedimiento> listarTodos() {
        return procedimientoRepository.findAll();
    }

    @Override
    public Procedimiento buscarPorId(Long id) {
        return procedimientoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Procedimiento con id " + id + " no encontrado"));
    }

    @Override
    public Procedimiento guardar(Procedimiento procedimiento) {
        return procedimientoRepository.save(procedimiento);
    }

    @Override
    public Procedimiento actualizar(Long id, Procedimiento procedimiento) {
        Procedimiento existente = buscarPorId(id);
        existente.setServicioId(procedimiento.getServicioId());
        existente.setPaso(procedimiento.getPaso());
        existente.setOrden(procedimiento.getOrden());
        return procedimientoRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Procedimiento existente = buscarPorId(id);
        procedimientoRepository.delete(existente);
    }

    @Override
    public List<Procedimiento> listarPorServicio(Long servicioId) {
        return procedimientoRepository.findByServicioId(servicioId);
    }
}