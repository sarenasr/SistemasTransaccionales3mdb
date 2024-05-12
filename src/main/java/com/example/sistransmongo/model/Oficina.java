package com.example.sistransmongo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("oficinas")
public class Oficina {
    @Id
    private String id;

    private String name;
    private String address;
    private int poi;
    private Usuario gerente;

    public Oficina(String id, String name, String address, int poi, Usuario gerente) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.poi = poi;
        this.gerente = gerente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPoi() {
        return poi;
    }

    public void setPoi(int poi) {
        this.poi = poi;
    }

    public Usuario getGerente() {
        return gerente;
    }

    public void setGerente(Usuario gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", poi=" + poi +
                ", gerente=" + gerente +
                '}';
    }
}
