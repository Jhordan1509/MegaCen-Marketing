package pe.com.megacentimetros.marketing.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "ProgramaFidelizacionEntity")
@Table(name = "programafidelizacion")
public class ProgramaFidelizacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codprog")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codcli", nullable = false, unique = true)
    private Long codcli;

    @Column(name = "punacu", nullable = false)
    private Integer puntosAcumulados;

    @Column(name = "nivel", length = 30, nullable = false)
    private String nivel;

    @Column(name = "fecins", nullable = false)
    private LocalDate fechaInscripcion;

    @Column(name = "estprogfid", nullable = false)
    private Boolean estado;

    @Transient
    private Object cliente;
}
