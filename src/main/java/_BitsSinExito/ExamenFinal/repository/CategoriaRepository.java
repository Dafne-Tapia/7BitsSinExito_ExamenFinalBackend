package _BitsSinExito.ExamenFinal.repository;

import _BitsSinExito.ExamenFinal.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
