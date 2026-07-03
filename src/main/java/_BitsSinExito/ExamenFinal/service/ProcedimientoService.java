package _BitsSinExito.ExamenFinal.service;

import _BitsSinExito.ExamenFinal.model.Procedimiento;
import java.util.List;

public interface ProcedimientoService {

    List<Procedimiento> listarTodos();

    Procedimiento buscarPorId(Long id);

    Procedimiento guardar(Procedimiento procedimiento);

    Procedimiento actualizar(Long id, Procedimiento procedimiento);

    void eliminar(Long id);

    List<Procedimiento> listarPorServicio(Long servicioId);
}