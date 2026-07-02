package _BitsSinExito.ExamenFinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "procedimientos")
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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getServicioId() { return servicioId; }
    public void setServicioId(Long servicioId) { this.servicioId = servicioId; }

    public String getPaso() { return paso; }
    public void setPaso(String paso) { this.paso = paso; }

    public Integer getOrden() { return orden; }
    public void setOrden(Integer orden) { this.orden = orden; }
}