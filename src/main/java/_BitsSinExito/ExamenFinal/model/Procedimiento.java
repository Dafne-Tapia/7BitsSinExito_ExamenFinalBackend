package _BitsSinExito.ExamenFinal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "procedimiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Procedimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "servicio_id")
    private Long servicioId;

    @Column(name = "paso")
    private String paso;

    @Column(name = "orden")
    private Integer orden;
}