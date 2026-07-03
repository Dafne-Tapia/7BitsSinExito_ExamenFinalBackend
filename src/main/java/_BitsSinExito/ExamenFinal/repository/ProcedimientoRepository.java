package _BitsSinExito.ExamenFinal.repository;

import _BitsSinExito.ExamenFinal.model.Procedimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProcedimientoRepository extends JpaRepository<Procedimiento, Long> {
    List<Procedimiento> findByServicioId(Long servicioId);
}