package cl.usach.ms_reparaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.usach.ms_reparaciones.entities.TipoReparacionesEntity;

@Repository
public interface TipoReparacionRepository extends JpaRepository<TipoReparacionesEntity, Long> {

}
