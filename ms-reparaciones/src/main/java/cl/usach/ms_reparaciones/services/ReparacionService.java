package cl.usach.ms_reparaciones.services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usach.ms_reparaciones.entities.ReparacionEntity;
import cl.usach.ms_reparaciones.models.ReparacionReq;
import cl.usach.ms_reparaciones.models.Reporte2Res;
import cl.usach.ms_reparaciones.repositories.ReparacionRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ReparacionService {

    @Autowired
    ReparacionRepository reparacionRepository;

    public List<ReparacionEntity> getAll() {
        return reparacionRepository.findAll();
    }

    public ReparacionEntity getReparacionById(Long id) {
        return reparacionRepository.findById(id).orElse(null);
    }
    
    public List<ReparacionEntity> getByMesAnio(int mes, int anio) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.clear();
    	calendar.set(Calendar.MONTH, mes-1);
    	calendar.set(Calendar.YEAR, anio);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	Date date = calendar.getTime();
    	System.out.println(date);
    	Timestamp ts = new Timestamp(date.getTime()); 
    	
    	Calendar calendar2 = Calendar.getInstance();
    	calendar2.clear();
    	calendar2.set(Calendar.MONTH, mes-1);
    	calendar2.set(Calendar.YEAR, anio);
    	calendar2.set(Calendar.DAY_OF_MONTH, YearMonth.of( anio , mes )
    	         .atEndOfMonth().getDayOfMonth());
    	Date date2 = calendar2.getTime();
    	System.out.println(date2);
    	Timestamp ts2 = new Timestamp(date2.getTime()); 
    	
    	
    	
        return reparacionRepository.getByMonth(ts, ts2);
    }
    
    
    public Collection<Reporte2Res> getReporte2(int mes, int anio) {
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.clear();
    	calendar.set(Calendar.MONTH, mes-1);
    	calendar.set(Calendar.YEAR, anio);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	Date date = calendar.getTime();
    	System.out.println(date);
    	Timestamp ts = new Timestamp(date.getTime()); 
    	
    	Calendar calendar2 = Calendar.getInstance();
    	calendar2.clear();
    	calendar2.set(Calendar.MONTH, mes-1);
    	calendar2.set(Calendar.YEAR, anio);
    	calendar2.set(Calendar.DAY_OF_MONTH, YearMonth.of( anio , mes )
    	         .atEndOfMonth().getDayOfMonth());
    	Date date2 = calendar2.getTime();
    	System.out.println(date2);
    	Timestamp ts2 = new Timestamp(date2.getTime()); 
    	
    	Calendar calendar3 = Calendar.getInstance();
    	calendar3.clear();
    	calendar3.set(Calendar.MONTH, mes-2);
    	calendar3.set(Calendar.YEAR, anio);
    	calendar3.set(Calendar.DAY_OF_MONTH, 1);
    	Date date3 = calendar.getTime();
    	System.out.println(date3);
    	Timestamp ts3 = new Timestamp(date3.getTime()); 
    	
    	Calendar calendar4 = Calendar.getInstance();
    	calendar4.clear();
    	calendar4.set(Calendar.MONTH, mes-2);
    	calendar4.set(Calendar.YEAR, anio);
    	calendar4.set(Calendar.DAY_OF_MONTH, YearMonth.of( anio , mes )
    	         .atEndOfMonth().getDayOfMonth());
    	Date date4 = calendar4.getTime();
    	System.out.println(date2);
    	Timestamp ts4 = new Timestamp(date4.getTime()); 
    	
    	Calendar calendar5 = Calendar.getInstance();
    	calendar5.clear();
    	calendar5.set(Calendar.MONTH, mes-3);
    	calendar5.set(Calendar.YEAR, anio);
    	calendar5.set(Calendar.DAY_OF_MONTH, 1);
    	Date date5 = calendar.getTime();
    	System.out.println(date5);
    	Timestamp ts5 = new Timestamp(date5.getTime()); 
    	
    	Calendar calendar6 = Calendar.getInstance();
    	calendar6.clear();
    	calendar6.set(Calendar.MONTH, mes-3);
    	calendar6.set(Calendar.YEAR, anio);
    	calendar6.set(Calendar.DAY_OF_MONTH, YearMonth.of( anio , mes )
    	         .atEndOfMonth().getDayOfMonth());
    	Date date6 = calendar6.getTime();
    	System.out.println(date6);
    	Timestamp ts6 = new Timestamp(date6.getTime()); 
    	
    	return reparacionRepository.getReport2(ts, ts2, ts3, ts4, ts5, ts6);
    	
    }

    public ReparacionEntity saveReparacion(ReparacionReq reparacion) {
    	try {
    	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	    Date parsedDate = dateFormat.parse(reparacion.getFecha_sal());
    	    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
    	
    	ReparacionEntity re = new ReparacionEntity();
    	
    	
    	re.setBono(reparacion.getBono());
    	re.setCosto_total(reparacion.getCosto_total());
    	re.setDescuento(reparacion.getDescuento());
    	re.setFecha_ing(reparacion.getFecha_ing());
    	re.setFecha_sal(timestamp);
    	re.setHora_ing(reparacion.getHora_ing());
    	re.setHora_sal(reparacion.getHora_sal());
    	re.setIva(reparacion.getIva());
    	re.setMonto_total_tiporep(reparacion.getMonto_total_tiporep());
    	re.setRecargo(reparacion.getRecargo());
    	re.setTipo_reparacion(reparacion.getTipo_reparacion());
    	re.setN_patente(reparacion.getN_patente());
    	re.setHora_sal_cli(reparacion.getHora_sal_cli());
    	re.setFecha_sal_cli(reparacion.getFecha_sal_cli());
    	re.setTipo_reparacion(reparacion.getTipo_reparacion());
    	
        ReparacionEntity reparacionNew = reparacionRepository.save(re);
        return reparacionNew;
    	} catch(Exception e) { //this generic but you can control another types of exception
    	    // look the origin of excption 
    	}
		return null;
    }

    public Integer obtenerReparacionPorPatente(String patente) {
        return reparacionRepository.findByPatente(patente);
    }


    public Integer reparaciondesc(String patente, String tipoMotor){
        int cantidad = obtenerReparacionPorPatente(patente);
        switch (tipoMotor){
            case "GASOLINA":
                if (cantidad>=1 && cantidad<=2){
                    return 5;
                }else if (cantidad>=3 && cantidad<=5){
                    return 10;

                }else if (cantidad>=6 && cantidad<=9) {
                    return 15;
                } else if (cantidad>=10) {
                    return 20;
                }else {
                    return 0;
                }
            case "DIESEL":
                if (cantidad>=1 && cantidad<=2){
                    return 7;
                }else if (cantidad>=3 && cantidad<=5){
                    return 12;

                }else if (cantidad>=6 && cantidad<=9) {
                    return 17;
                } else if (cantidad>=10) {
                    return 22;
                }else {
                    return 0;
                }
            case "HIBRIDO":
                if (cantidad>=1 && cantidad<=2){
                    return 10;
                }else if (cantidad>=3 && cantidad<=5){
                    return 15;

                }else if (cantidad>=6 && cantidad<=9) {
                    return 20;
                } else if (cantidad>=10) {
                    return 25;
                }else {
                    return 0;
                }
            case "ELECTRICO":
                if (cantidad>=1 && cantidad<=2){
                    return 8;
                }else if (cantidad>=3 && cantidad<=5){
                    return 13;

                }else if (cantidad>=6 && cantidad<=9) {
                    return 18;
                } else if (cantidad>=10) {
                    return 23;
                }else {
                    return 0;
                }
        }
        return -1;
    }

    public ReparacionEntity modificarReparacionSalida(Long id, String fecha_salida, String hora_salida) {
        Optional<ReparacionEntity> reparacion = reparacionRepository.findById(id);
        if (reparacion.isPresent()) {
            ReparacionEntity reparacionEntity = reparacion.get();
            reparacionEntity.setFecha_sal_cli(fecha_salida);
            reparacionEntity.setHora_sal_cli(hora_salida);
            return reparacionRepository.save(reparacionEntity);
        } else {
            // Aquí puedes manejar el caso en que no se encuentra la reparación
            // Por ejemplo, puedes lanzar una excepción o retornar null
            throw new EntityNotFoundException("Reparación con id " + id + " no encontrada");
        }
    }

    public ReparacionEntity modificarReparacionListo(Long id, Timestamp fecha_salida, String hora_salida) {
        Optional<ReparacionEntity> reparacion = reparacionRepository.findById(id);
        if (reparacion.isPresent()) {
            ReparacionEntity reparacionEntity = reparacion.get();
            reparacionEntity.setFecha_sal(fecha_salida);
            reparacionEntity.setHora_sal(hora_salida);
            return reparacionRepository.save(reparacionEntity);
        } else {
            return null;
        }
    }



}