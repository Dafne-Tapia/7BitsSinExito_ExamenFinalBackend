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
}