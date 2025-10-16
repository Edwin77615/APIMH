package com.mh.apifacturacion.service;

import com.mh.apifacturacion.dto.RecepcionResponse;
import com.mh.apifacturacion.model.DteDocument;
import com.mh.apifacturacion.repository.DteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.UUID;

@Service
public class RecepcionServiceImpl implements RecepcionService {
    private final DteRepository dteRepository;

    public RecepcionServiceImpl(DteRepository dteRepository) {
        this.dteRepository = dteRepository;
    }

    @Override
    public RecepcionResponse processSync(Map<String, Object> peticion) {
        RecepcionResponse resp = new RecepcionResponse();
        Object nit = peticion.get("nitEmisor");
        if (nit == null || !nit.toString().matches("\\d{9,14}")) {
            resp.setEstado("RECHAZADO");
            resp.setCodigoMsg("ERR_NIT");
            resp.setDescripcionMsg("nitEmisor inválido");
            return resp;
        }

        String codigoGen = UUID.randomUUID().toString().toUpperCase();
        DteDocument doc = new DteDocument();
        doc.setCodigoGeneracion(codigoGen);
        doc.setNitEmisor(nit.toString());
        doc.setRawJson(peticion.toString());
        doc.setEstado("PROCESADO");
        doc.setFhProcesamiento(LocalDateTime.now());
        dteRepository.save(doc);

        resp.setEstado("PROCESADO");
        resp.setCodigoGeneracion(codigoGen);
        resp.setSelloRecibido("SIMULADO-SELLO-" + UUID.randomUUID().toString());
        resp.setFhProcesamiento(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        resp.setCodigoMsg("001");
        resp.setDescripcionMsg("RECIBIDO");
        return resp;
    }
}
