package _BitsSinExito.ExamenFinal.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "requisitos")
public class Requisito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;

    @Column(nullable = false, length = 255)
    private String requisito;

    @Column(nullable = false)
    private Boolean obligatorio = true;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "orden_presentacion")
    private Integer orden;

    @Column(nullable = false, length = 20)
    private String estado = "Activo";
}
