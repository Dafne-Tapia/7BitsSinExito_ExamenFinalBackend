package _BitsSinExito.ExamenFinal.repository;

import _BitsSinExito.ExamenFinal.model.Horario;
import _BitsSinExito.ExamenFinal.model.Procedimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Procedimiento> findByServicioId(Long servicioId);
}