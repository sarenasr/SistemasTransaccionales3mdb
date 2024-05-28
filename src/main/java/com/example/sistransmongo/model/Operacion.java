package com.example.sistransmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("operaciones")
public class Operacion {
    @Id
    private String id;
    private double valor;
    private LocalDateTime fecha;
    private String tipoOperacion;
    private String cuentaOrigen;
    private String cuentaSalida;

    public Operacion(String id, double valor, LocalDateTime fecha, String tipoOperacion, String cuentaOrigen, String cuentaSalida) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.tipoOperacion = tipoOperacion;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaSalida = cuentaSalida;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaSalida() {
        return cuentaSalida;
    }

    public void setCuentaSalida(String cuentaSalida) {
        this.cuentaSalida = cuentaSalida;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", fecha=" + fecha +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", cuentaOrigen='" + cuentaOrigen + '\'' +
                ", cuentaSalida='" + cuentaSalida + '\'' +
                '}';
    }
}
