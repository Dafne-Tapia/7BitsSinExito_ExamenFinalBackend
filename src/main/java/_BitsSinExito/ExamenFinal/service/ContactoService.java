package _BitsSinExito.ExamenFinal.service;

import _BitsSinExito.ExamenFinal.model.Contacto;
import _BitsSinExito.ExamenFinal.repository.ContactoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactoService {

    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public List<Contacto> obtenerTodos() {
        return contactoRepository.findAllByOrderByOrdenAsc();
    }

    public Contacto agregar(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    public Contacto actualizar(Long id, Contacto contactoActualizado) {
        contactoActualizado.setId(id);
        return contactoRepository.save(contactoActualizado);
    }

    public boolean eliminar(Long id) {
        if (contactoRepository.existsById(id)) {
            contactoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}