package com.example.sistransmongo.repository;

import com.example.sistransmongo.model.Operacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OperacionRepository extends MongoRepository<Operacion, String> {

    public long count();

}
