package com.mh.apifacturacion.service;

import java.util.Map;
import com.mh.apifacturacion.dto.RecepcionResponse;

public interface RecepcionService {
    RecepcionResponse processSync(Map<String, Object> peticion);
}
