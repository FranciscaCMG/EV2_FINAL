package cl.usach.ms_reparaciones.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reparacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReparacionEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reparacion_sequence")
	@SequenceGenerator(name = "reparacion_sequence", sequenceName = "reparacion_sequence",  allocationSize=1)
//    @Column(name = "id", nullable = false)
    private long id;

    private String n_patente;
    private String fecha_ing;
    private String hora_ing;
    private Boolean bono;
    private Float monto_total_tiporep;
    private Float recargo;
    private Float descuento;
    private Float iva;
    private Float costo_total;
    private Timestamp fecha_sal;
    private String hora_sal;
    private String fecha_sal_cli;
    private String hora_sal_cli;
    private long tipo_reparacion;
    
}
