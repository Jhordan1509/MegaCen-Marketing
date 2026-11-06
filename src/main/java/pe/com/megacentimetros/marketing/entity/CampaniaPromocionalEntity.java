package pe.com.megacentimetros.marketing.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Entity(name = "CampaniaPromocionalEntity")
@Table(name = "campaniapromocional")
public class CampaniaPromocionalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codcamp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomcamp", length = 120, nullable = false)
    private String nombre;

    @Column(name = "descrip", length = 300)
    private String descripcion;

    @Column(name = "fecini", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecfin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "tipdesc", length = 30, nullable = false)
    private String tipoDescuento;

    @Column(name = "valdesc", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDescuento;

    @Column(name = "sitcamp", length = 30, nullable = false)
    private String situacion;

    @Column(name = "estcamp", nullable = false)
    private Boolean estado;
}
