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

    public List<Procedimiento> listarPorServicio(Long servicioId) {
        return procedimientoRepository.findByServicioId(servicioId);
    }
}