package cl.usach.ms_reparaciones.entities;

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
@Table(name="tipo_reparaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoReparacionesEntity {
	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tiporeparacion_sequence")
	@SequenceGenerator(name = "tiporeparacion_sequence", sequenceName = "tiporeparacion_sequence",  allocationSize=1)
    @Id
    private long id;
    private String tipo;

}
