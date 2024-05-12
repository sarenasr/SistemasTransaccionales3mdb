package com.example.sistransmongo.repository;

import com.example.sistransmongo.model.Oficina;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OficinaRepository  extends MongoRepository<Oficina, String> {

    public long count();
}
