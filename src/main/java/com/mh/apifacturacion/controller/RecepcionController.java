package com.mh.apifacturacion.controller;

import com.mh.apifacturacion.dto.RecepcionResponse;
import com.mh.apifacturacion.service.RecepcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/fesv")
public class RecepcionController {
    private final RecepcionService recepcionService;
    public RecepcionController(RecepcionService recepcionService) { this.recepcionService = recepcionService; }

    @PostMapping("/recepciondte")
    public ResponseEntity<RecepcionResponse> recepcion(@RequestHeader(value = "Authorization", required = false) String auth,
                                                       @RequestBody Map<String, Object> peticion) {
        // Nota: en este ejemplo simplificado no validamos token.
        RecepcionResponse resp = recepcionService.processSync(peticion);
        if ("RECHAZADO".equals(resp.getEstado())) {
            return ResponseEntity.badRequest().body(resp);
        }
        return ResponseEntity.ok(resp);
    }
}
