package cl.usach.ms_listas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.usach.ms_listas.models.ListaResponse;
import cl.usach.ms_listas.models.ReparacionEntity;
import cl.usach.ms_listas.models.VehiculoEntity;

@Service
public class ListasService {

	private final String URL_REPARACIONES = "http://localhost:8093/reparacion";
	private final String URL_VEHICULOS = "http://localhost:8092/vehiculo";
	private ObjectMapper objectMapper = new ObjectMapper();

	
	public List<ListaResponse> getList() throws JsonMappingException, JsonProcessingException {
		ReparacionEntity obj1 = new ReparacionEntity();
		List<ReparacionEntity> listReparacion = new ArrayList<>();
		List<ListaResponse> listResp = new ArrayList<>();
		ListaResponse lr;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> packetEntity = new HttpEntity(obj1, headers);

		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		ResponseEntity<String> result = restTemplate.exchange(URL_REPARACIONES, HttpMethod.GET, packetEntity,
				String.class);
		listReparacion = objectMapper.readValue(result.getBody(), new TypeReference<List<ReparacionEntity>>() {
		});
		
		for(ReparacionEntity r: listReparacion) {
			lr = new ListaResponse();
			VehiculoEntity v = getVehiculoByPatent(r.getN_patente());
			lr.setAnio_fabricacion(v.getAnio_fabricacion());
			lr.setBono(r.getBono());
			lr.setCosto_total(r.getCosto_total());
			lr.setDescuento(r.getDescuento());
			lr.setFecha_ing(r.getFecha_ing());
			lr.setFecha_sal(r.getFecha_sal());
			lr.setHora_ing(r.getHora_ing());
			lr.setHora_sal(r.getHora_sal());
			lr.setIva(r.getIva());
			lr.setKilometraje(v.getKilometraje());
			lr.setMarca(v.getMarca());
			lr.setModelo(v.getModelo());
			lr.setMonto_total_tiporep(r.getMonto_total_tiporep());
			lr.setN_asientos(v.getN_asientos());
			lr.setN_patente(v.getNpatente());
			lr.setRecargo(r.getRecargo());
			lr.setTipo_auto(v.getTipo_auto());
			lr.setTipo_motor(v.getTipo_motor());
			lr.setTipo_reparacion(r.getTipo_reparacion());
			listResp.add(lr);
		}

		return listResp;

	}
	
	public List<ListaResponse> getListByMonth(int mes, int anio) throws JsonMappingException, JsonProcessingException {
		ReparacionEntity obj1 = new ReparacionEntity();
		List<ReparacionEntity> listReparacion = new ArrayList<>();
		List<ListaResponse> listResp = new ArrayList<>();
		ListaResponse lr;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> packetEntity = new HttpEntity(obj1, headers);

		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		ResponseEntity<String> result = restTemplate.exchange(URL_REPARACIONES+"/"+mes+"/"+anio, HttpMethod.GET, packetEntity,
				String.class);
		listReparacion = objectMapper.readValue(result.getBody(), new TypeReference<List<ReparacionEntity>>() {
		});
		
		for(ReparacionEntity r: listReparacion) {
			lr = new ListaResponse();
			VehiculoEntity v = getVehiculoByPatent(r.getN_patente());
			lr.setAnio_fabricacion(v.getAnio_fabricacion());
			lr.setBono(r.getBono());
			lr.setCosto_total(r.getCosto_total());
			lr.setDescuento(r.getDescuento());
			lr.setFecha_ing(r.getFecha_ing());
			lr.setFecha_sal(r.getFecha_sal());
			lr.setHora_ing(r.getHora_ing());
			lr.setHora_sal(r.getHora_sal());
			lr.setIva(r.getIva());
			lr.setKilometraje(v.getKilometraje());
			lr.setMarca(v.getMarca());
			lr.setModelo(v.getModelo());
			lr.setMonto_total_tiporep(r.getMonto_total_tiporep());
			lr.setN_asientos(v.getN_asientos());
			lr.setN_patente(v.getNpatente());
			lr.setRecargo(r.getRecargo());
			lr.setTipo_auto(v.getTipo_auto());
			lr.setTipo_motor(v.getTipo_motor());
			lr.setTipo_reparacion(r.getTipo_reparacion());
			listResp.add(lr);
		}

		return listResp;

	}
	
	public List<ListaResponse> getListDosMesesYActual(int mes, int anio) throws JsonMappingException, JsonProcessingException {
		ReparacionEntity obj1 = new ReparacionEntity();
		List<ReparacionEntity> listReparacion = new ArrayList<>();
		List<ListaResponse> listResp = new ArrayList<>();
		ListaResponse lr;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> packetEntity = new HttpEntity(obj1, headers);

		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		ResponseEntity<String> result = restTemplate.exchange(URL_REPARACIONES+"/dosmeses"+"/"+mes+"/"+anio, HttpMethod.GET, packetEntity,
				String.class);
		listReparacion = objectMapper.readValue(result.getBody(), new TypeReference<List<ReparacionEntity>>() {
		});
		
		for(ReparacionEntity r: listReparacion) {
			lr = new ListaResponse();
			VehiculoEntity v = getVehiculoByPatent(r.getN_patente());
			lr.setAnio_fabricacion(v.getAnio_fabricacion());
			lr.setBono(r.getBono());
			lr.setCosto_total(r.getCosto_total());
			lr.setDescuento(r.getDescuento());
			lr.setFecha_ing(r.getFecha_ing());
			lr.setFecha_sal(r.getFecha_sal());
			lr.setHora_ing(r.getHora_ing());
			lr.setHora_sal(r.getHora_sal());
			lr.setIva(r.getIva());
			lr.setKilometraje(v.getKilometraje());
			lr.setMarca(v.getMarca());
			lr.setModelo(v.getModelo());
			lr.setMonto_total_tiporep(r.getMonto_total_tiporep());
			lr.setN_asientos(v.getN_asientos());
			lr.setN_patente(v.getNpatente());
			lr.setRecargo(r.getRecargo());
			lr.setTipo_auto(v.getTipo_auto());
			lr.setTipo_motor(v.getTipo_motor());
			lr.setTipo_reparacion(r.getTipo_reparacion());
			listResp.add(lr);
		}

		return listResp;

	}

	public VehiculoEntity getVehiculoByPatent(String patent) {
		VehiculoEntity obj1 = new VehiculoEntity();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> packetEntity = new HttpEntity(obj1, headers);

		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		ResponseEntity<String> result = restTemplate.exchange(URL_VEHICULOS+"/"+patent, HttpMethod.GET, packetEntity,
				String.class);
		
		try {
			return objectMapper.readValue(result.getBody(), VehiculoEntity.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
