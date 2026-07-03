package _BitsSinExito.ExamenFinal.repository;

import _BitsSinExito.ExamenFinal.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    List<Contacto> findAllByOrderByOrdenAsc();
}