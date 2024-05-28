package com.example.sistransmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("cuentas")
public class Cuenta {

    @Id
    private String accountNumber;
    private String accountType;
    private double amount;
    private LocalDateTime lastTransaction;
    private Boolean state;
    private Usuario user;
    private List<Operacion> operaciones;

    public Cuenta(String accountNumber, String accountType, double amount, LocalDateTime lastTransaction, Boolean state, Usuario user, List<Operacion> operaciones) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;
        this.lastTransaction = lastTransaction;
        this.state = state;
        this.user = user;
        this.operaciones = operaciones;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(LocalDateTime lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }

    public void addOperacion(Operacion operacion) {
        this.operaciones.add(operacion);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", amount=" + amount +
                ", lastTransaction=" + lastTransaction +
                ", state=" + state +
                ", user=" + user + "\n"+
                ", operaciones=" + operaciones +
                '}';
    }
}
