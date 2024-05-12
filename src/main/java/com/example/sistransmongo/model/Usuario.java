package com.example.sistransmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("usuarios")
public class Usuario {

    @Id
    private String id;

    private String login;
    private String password;
    private String name;
    private String nationality;
    private String email;
    private String address;
    private String phone;
    private String city;
    private String state;
    private String postalCode;
    private String idType;
    private String personType;
    private String userType;

    public Usuario(String login, String id, String password, String name, String nationality, String email, String address, String phone, String city, String state, String postalCode, String idType, String personType, String userType) {
        this.login = login;
        this.id = id;
        this.password = password;
        this.name = name;
        this.nationality = nationality;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.idType = idType;
        this.personType = personType;
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' + ",\n"+
                "        address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' + ",\n"+
                "        postalCode='" + postalCode + '\'' +
                ", idType='" + idType + '\'' +
                ", personType='" + personType + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}


