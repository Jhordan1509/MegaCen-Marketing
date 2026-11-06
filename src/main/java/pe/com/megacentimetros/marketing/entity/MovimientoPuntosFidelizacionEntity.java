package pe.com.megacentimetros.marketing.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "MovimientoPuntosFidelizacionEntity")
@Table(name = "movimientopuntosfidelizacion")
public class MovimientoPuntosFidelizacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codmovpun")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codprog", nullable = false)
    private Long codprog;

    @Column(name = "tipmov", length = 30, nullable = false)
    private String tipo;

    @Column(name = "puntos", nullable = false)
    private Integer puntos;

    @Column(name = "descrip", length = 250)
    private String descripcion;

    @Column(name = "fecmov", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "estmovpuntos", nullable = false)
    private Boolean estado;
}
