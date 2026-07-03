package _BitsSinExito.ExamenFinal.repository;

import _BitsSinExito.ExamenFinal.model.Requisito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RequisitoRepository extends JpaRepository<Requisito, Long> {
    List<Requisito> findByServicioIdOrderByOrdenAsc(Long servicioId);
}