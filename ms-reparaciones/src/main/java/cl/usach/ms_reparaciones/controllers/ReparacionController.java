package cl.usach.ms_reparaciones.controllers;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.ms_reparaciones.entities.ReparacionEntity;
import cl.usach.ms_reparaciones.entities.TipoReparacionesEntity;
import cl.usach.ms_reparaciones.models.ReparacionReq;
import cl.usach.ms_reparaciones.models.Reporte2Res;
import cl.usach.ms_reparaciones.services.ReparacionService;
import cl.usach.ms_reparaciones.services.TipoReparacionService;

@RestController
@RequestMapping("/reparacion")
@CrossOrigin("*")
public class ReparacionController {
    @Autowired
    private ReparacionService reparacionService;
    @Autowired
    private TipoReparacionService tipoReparacionService;

    @GetMapping
    public ResponseEntity<List<ReparacionEntity>> getAll() {
        List<ReparacionEntity> reparaciones = reparacionService.getAll();
        if(reparaciones.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(reparaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReparacionEntity> getById(@PathVariable ("id") Long id) {
        ReparacionEntity reparacion = reparacionService.getReparacionById(id);
        if(reparacion == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reparacion);
    }
    
    @GetMapping("/tiposreparacion")
    public ResponseEntity<List<TipoReparacionesEntity>> getById() {
        List<TipoReparacionesEntity> tipos = tipoReparacionService.gettiposReparacion();
        if(tipos == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(tipos);
    }
    
    @GetMapping("/{mes}/{anio}")
    public ResponseEntity<List<ReparacionEntity>> getByMesAnio(@PathVariable ("mes") int mes, @PathVariable ("anio") int anio) {
        List<ReparacionEntity> reparaciones = reparacionService.getByMesAnio(mes, anio);
        if(reparaciones == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reparaciones);
    }
    
    
    @GetMapping("/reporte2/{mes}/{anio}")
    public ResponseEntity<Collection<Reporte2Res>> getByDosMesesYActual(@PathVariable ("mes") int mes, @PathVariable ("anio") int anio) {
        Collection<Reporte2Res> reparaciones = reparacionService.getReporte2(mes, anio);
        if(reparaciones == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(reparaciones);
    }

    @PostMapping()
    public ResponseEntity<ReparacionEntity> save(@RequestBody ReparacionReq reparacion) {
        ReparacionEntity reparacionNew = reparacionService.saveReparacion(reparacion);
        return ResponseEntity.ok(reparacionNew);
    }

    @GetMapping("/reparaciondesc/{patente}/{tipo_motor}")
    public ResponseEntity<Integer> reparaciondesc(@PathVariable String patente, @PathVariable String tipo_motor) {
        Integer reparaciondesc = reparacionService.reparaciondesc(patente, tipo_motor);
        return ResponseEntity.ok(reparaciondesc);
    }

    @PatchMapping("/modificarSalida/{id}/{fecha_salida}/{hora_salida}")
    public ResponseEntity<ReparacionEntity> modificarReparacionSalida(@PathVariable Long id, @PathVariable String fecha_salida,@PathVariable String hora_salida) {
        ReparacionEntity reparacionModificado = reparacionService.modificarReparacionSalida(id, fecha_salida, hora_salida);
        return ResponseEntity.ok(reparacionModificado);
    }

    @PatchMapping("/modificarListo/{id}/{fecha_salida}/{hora_salida}")
    public ResponseEntity<ReparacionEntity> modificarReparacionListo(@PathVariable Long id, @PathVariable Timestamp fecha_salida,@PathVariable String hora_salida) {
        ReparacionEntity reparacionModificado = reparacionService.modificarReparacionListo(id, fecha_salida, hora_salida);
        return ResponseEntity.ok(reparacionModificado);
    }


}
