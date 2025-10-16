package com.mh.apifacturacion.repository;

import com.mh.apifacturacion.model.DteDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DteRepository extends JpaRepository<DteDocument, Long> {
    DteDocument findByCodigoGeneracion(String codigoGeneracion);
}
