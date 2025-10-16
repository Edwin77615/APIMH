package com.mh.apifacturacion.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dte_document")
public class DteDocument {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "codigo_generacion", unique = true)
  private String codigoGeneracion;

  @Column(name = "nit_emisor", length = 14)
  private String nitEmisor;

  @Column(columnDefinition = "text")
  private String rawJson;

  @Column(name = "estado")
  private String estado;

  @Column(name = "fh_procesamiento")
  private LocalDateTime fhProcesamiento;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getCodigoGeneracion() { return codigoGeneracion; }
  public void setCodigoGeneracion(String codigoGeneracion) { this.codigoGeneracion = codigoGeneracion; }
  public String getNitEmisor() { return nitEmisor; }
  public void setNitEmisor(String nitEmisor) { this.nitEmisor = nitEmisor; }
  public String getRawJson() { return rawJson; }
  public void setRawJson(String rawJson) { this.rawJson = rawJson; }
  public String getEstado() { return estado; }
  public void setEstado(String estado) { this.estado = estado; }
  public LocalDateTime getFhProcesamiento() { return fhProcesamiento; }
  public void setFhProcesamiento(LocalDateTime fhProcesamiento) { this.fhProcesamiento = fhProcesamiento; }
}
