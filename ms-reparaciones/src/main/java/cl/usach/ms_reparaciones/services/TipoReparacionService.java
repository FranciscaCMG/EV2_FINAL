package cl.usach.ms_reparaciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.ms_reparaciones.entities.TipoReparacionesEntity;
import cl.usach.ms_reparaciones.repositories.TipoReparacionRepository;

@Service
public class TipoReparacionService {
	
	@Autowired
	private TipoReparacionRepository tipoReparacionRepository;
	
	
	public List<TipoReparacionesEntity> gettiposReparacion() {
		return tipoReparacionRepository.findAll();
	}
}
