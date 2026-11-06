package pe.com.megacentimetros.marketing.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Entity(name = "ClienteCampaniaEntity")
@Table(name = "clientecampania")
public class ClienteCampaniaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codclicamp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codcli", nullable = false)
    private Long codcli;

    @Column(name = "codcamp", nullable = false)
    private Long codcamp;

    @Column(name = "fecasig", nullable = false)
    private LocalDateTime fechaAsignacion;

    @Column(name = "estclicamp", nullable = false)
    private Boolean estado;

    @Transient
    private Object cliente;
}
