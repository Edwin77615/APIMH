package com.mh.apifacturacion.dto;

public class RecepcionResponse {
    private String estado;
    private String codigoGeneracion;
    private String selloRecibido;
    private String fhProcesamiento;
    private String codigoMsg;
    private String descripcionMsg;

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getCodigoGeneracion() { return codigoGeneracion; }
    public void setCodigoGeneracion(String codigoGeneracion) { this.codigoGeneracion = codigoGeneracion; }
    public String getSelloRecibido() { return selloRecibido; }
    public void setSelloRecibido(String selloRecibido) { this.selloRecibido = selloRecibido; }
    public String getFhProcesamiento() { return fhProcesamiento; }
    public void setFhProcesamiento(String fhProcesamiento) { this.fhProcesamiento = fhProcesamiento; }
    public String getCodigoMsg() { return codigoMsg; }
    public void setCodigoMsg(String codigoMsg) { this.codigoMsg = codigoMsg; }
    public String getDescripcionMsg() { return descripcionMsg; }
    public void setDescripcionMsg(String descripcionMsg) { this.descripcionMsg = descripcionMsg; }
}
