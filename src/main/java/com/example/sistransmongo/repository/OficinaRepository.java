package com.example.sistransmongo.repository;

import com.example.sistransmongo.model.Oficina;
import com.example.sistransmongo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OficinaRepository  extends MongoRepository<Oficina, String> {

    @Query("{_id: '?0'}")
    Oficina findOficinaById(String id);

    public long count();
}
