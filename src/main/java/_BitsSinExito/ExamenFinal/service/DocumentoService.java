package _BitsSinExito.ExamenFinal.service;

import _BitsSinExito.ExamenFinal.model.Documento;
import _BitsSinExito.ExamenFinal.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> obtenerTodos() {
        return documentoRepository.findAll();
    }

    public Optional<Documento> obtenerPorId(Long id) {
        return documentoRepository.findById(id);
    }

    public List<Documento> obtenerPorServicioId(Long servicioId) {
        return documentoRepository.findByServicioId(servicioId);
    }

    public Documento guardar(Documento documento) {
        return documentoRepository.save(documento);
    }

    public void eliminar(Long id) {
        documentoRepository.deleteById(id);
    }
}
