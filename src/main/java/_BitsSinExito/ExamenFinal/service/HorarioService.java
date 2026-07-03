package _BitsSinExito.ExamenFinal.service;

import _BitsSinExito.ExamenFinal.model.Horario;

import java.util.List;

public interface HorarioService {
    List<Horario> obtenerTodos();
    Horario obtenerPorId(Long id);
    Horario crear(Horario horario);
    Horario actualizar(Long id, Horario horario);
    void eliminar(Long id);
}
