package _BitsSinExito.ExamenFinal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contacto")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "valor")
    private String valor;

    @Column(name = "orden")
    private int orden;

    public Contacto() {}

    public Contacto(String tipo, String descripcion, String valor, int orden) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.valor = valor;
        this.orden = orden;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public int getOrden() { return orden; }
    public void setOrden(int orden) { this.orden = orden; }
}
