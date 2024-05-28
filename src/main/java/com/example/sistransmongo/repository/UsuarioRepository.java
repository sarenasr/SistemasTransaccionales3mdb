package com.example.sistransmongo.repository;

import com.example.sistransmongo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import java.util.List;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    @Query("{name: '?0'}")
    Usuario findUsuarioByName(String name);

    @Query("{_id: '?0'}")
    Usuario findUsuarioById(String id);

    @Query("{login: '?0'}")
    Usuario findUsuarioByLogin(String login);

    @Query(value="{userType: '?0'}", fields = "{'_id': 1,'name': 1}")
    List<Usuario> findAllBy(String userType);

    public long count();

}
