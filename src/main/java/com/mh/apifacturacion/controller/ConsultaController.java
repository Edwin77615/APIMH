package com.mh.apifacturacion.controller;

import com.mh.apifacturacion.model.DteDocument;
import com.mh.apifacturacion.repository.DteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fesv")
public class ConsultaController {
    private final DteRepository dteRepository;
    public ConsultaController(DteRepository dteRepository) { this.dteRepository = dteRepository; }

    @GetMapping("/consulta/{codigo}")
    public ResponseEntity<?> consulta(@PathVariable("codigo") String codigo) {
        DteDocument d = dteRepository.findByCodigoGeneracion(codigo);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(d);
    }
}
