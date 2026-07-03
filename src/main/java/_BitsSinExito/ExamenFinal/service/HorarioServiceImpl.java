package _BitsSinExito.ExamenFinal.service;

import _BitsSinExito.ExamenFinal.model.Horario;
import _BitsSinExito.ExamenFinal.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService {

    private final HorarioRepository horarioRepository;

    @Autowired
    public HorarioServiceImpl(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    @Override
    public List<Horario> obtenerTodos() {
        return horarioRepository.findAll();
    }

    @Override
    public Horario obtenerPorId(Long id) {
        return horarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Horario con id " + id + " no encontrado"));
    }

    @Override
    public Horario crear(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public Horario actualizar(Long id, Horario horario) {
        Horario existente = obtenerPorId(id);
        existente.setServicio(horario.getServicio());
        existente.setDia(horario.getDia());
        existente.setHoraInicio(horario.getHoraInicio());
        existente.setHoraFin(horario.getHoraFin());
        return horarioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Horario existente = obtenerPorId(id);
        horarioRepository.delete(existente);
    }
}
