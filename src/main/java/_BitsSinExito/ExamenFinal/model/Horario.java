package _BitsSinExito.ExamenFinal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "horario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Servicio servicio;

    @Column(nullable = false, length = 20)
    private String dia;

    @Column(name = "hora_inicio", nullable = false)
    @JsonIgnore
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    @JsonIgnore
    private LocalTime horaFin;

    @JsonProperty("horaInicio")
    public String getHoraInicioTexto() {
        return horaInicio != null ? horaInicio.format(FORMATO_HORA) : null;
    }

    @JsonProperty("horaInicio")
    public void setHoraInicioTexto(String horaInicio) {
        this.horaInicio = (horaInicio != null && !horaInicio.isBlank())
                ? LocalTime.parse(horaInicio, FORMATO_HORA)
                : null;
    }

    @JsonProperty("horaFin")
    public String getHoraFinTexto() {
        return horaFin != null ? horaFin.format(FORMATO_HORA) : null;
    }

    @JsonProperty("horaFin")
    public void setHoraFinTexto(String horaFin) {
        this.horaFin = (horaFin != null && !horaFin.isBlank())
                ? LocalTime.parse(horaFin, FORMATO_HORA)
                : null;
    }
}