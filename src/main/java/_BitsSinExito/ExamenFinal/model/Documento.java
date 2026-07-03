package _BitsSinExito.ExamenFinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "servicio_id", nullable = false)
    private Long servicioId;

    @Column(name = "nombre_documento", nullable = false)
    private String nombreDocumento;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "formato")
    private String formato;

    public Documento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getServicioId() { return servicioId; }
    public void setServicioId(Long servicioId) { this.servicioId = servicioId; }

    public String getNombreDocumento() { return nombreDocumento; }
    public void setNombreDocumento(String nombreDocumento) { this.nombreDocumento = nombreDocumento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
}

