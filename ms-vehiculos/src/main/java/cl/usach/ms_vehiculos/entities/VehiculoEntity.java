package cl.usach.ms_vehiculos.entities;

import jakarta.persistence.Column;
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
@Table(name="vehiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_sequence")
	@SequenceGenerator(name = "vehiculo_sequence", sequenceName = "vehiculo_sequence",  allocationSize=1)
    private long id;
    
    @Column(name = "n_patente", nullable = false)
    private String npatente;

    private String marca;
    private String modelo;
    private String tipo_auto;
    private String anio_fabricacion;
    private String tipo_motor;
    private Integer n_asientos;
    private Integer kilometraje;

}