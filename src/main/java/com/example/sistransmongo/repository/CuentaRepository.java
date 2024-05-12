package com.example.sistransmongo.repository;

import com.example.sistransmongo.model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {

    public long count();


}
