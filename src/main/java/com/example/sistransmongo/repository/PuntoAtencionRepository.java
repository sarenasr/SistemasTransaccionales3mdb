package com.example.sistransmongo.repository;

import com.example.sistransmongo.model.PuntoAtencion;
import com.example.sistransmongo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PuntoAtencionRepository extends MongoRepository<PuntoAtencion, String> {

    @Query("{_id: '?0'}")
    PuntoAtencion findPuntoAtencionById(String id);

    public long count();

}
