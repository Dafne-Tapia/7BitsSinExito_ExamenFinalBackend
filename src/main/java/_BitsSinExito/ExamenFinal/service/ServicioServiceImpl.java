package _BitsSinExito.ExamenFinal.service;

import _BitsSinExito.ExamenFinal.model.Servicio;
import _BitsSinExito.ExamenFinal.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;

    @Autowired
    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public List<Servicio> obtenerTodos() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio obtenerPorId(Long id) {
        return servicioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Servicio con id " + id + " no encontrado"));
    }

    @Override
    public Servicio crear(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio actualizar(Long id, Servicio servicio) {
        Servicio existente = obtenerPorId(id);
        existente.setNombre(servicio.getNombre());
        existente.setDescripcion(servicio.getDescripcion());
        existente.setCategoria(servicio.getCategoria());
        existente.setEstado(servicio.getEstado());
        existente.setImagen(servicio.getImagen());
        return servicioRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Servicio existente = obtenerPorId(id);
        servicioRepository.delete(existente);
    }
}
