package com.example.sistransmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("puntos_de_atencion")
public class PuntoAtencion {

    @Id
    private String id;
    private String tipo;
    private String localizacion;

    public PuntoAtencion(String id, String tipo, String localizacion) {
        this.id = id;
        this.tipo = tipo;
        this.localizacion = localizacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        return "PuntoAtencion{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", localizacion='" + localizacion + '\'' +
                '}';
    }
}
