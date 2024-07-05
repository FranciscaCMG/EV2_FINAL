package cl.usach.ms_listas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cl.usach.ms_listas.models.ListaResponse;
import cl.usach.ms_listas.services.ListasService;

@RestController
@RequestMapping("/listas")
@CrossOrigin("*")
public class ListasController {

	@Autowired
	private ListasService listasService;

	@GetMapping
	public ResponseEntity<List<ListaResponse>> getList() throws JsonMappingException, JsonProcessingException {
	        List<ListaResponse> lista = listasService.getList();
	        if(lista.isEmpty())
	            return ResponseEntity.noContent().build();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{mes}/{anio}")
	public ResponseEntity<List<ListaResponse>> getListByMonth(@PathVariable ("mes") int mes, @PathVariable ("anio") int anio) throws JsonMappingException, JsonProcessingException {
	        List<ListaResponse> lista = listasService.getListByMonth(mes, anio);
	        if(lista.isEmpty())
	            return ResponseEntity.noContent().build();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/dosmeses/{mes}/{anio}")
	public ResponseEntity<List<ListaResponse>> getDosMesesYActual(@PathVariable ("mes") int mes, @PathVariable ("anio") int anio) throws JsonMappingException, JsonProcessingException {
	        List<ListaResponse> lista = listasService.getListDosMesesYActual(mes, anio);
	        if(lista.isEmpty())
	            return ResponseEntity.noContent().build();
		return ResponseEntity.ok(lista);
	}
	
}
