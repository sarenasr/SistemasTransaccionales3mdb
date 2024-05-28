package com.example.sistransmongo.repository;

import com.example.sistransmongo.model.Cuenta;
import com.example.sistransmongo.model.Operacion;
import com.example.sistransmongo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {

    @Query("{accountNumber: '?0'}")
    Cuenta findCuentasById(String id);

    //@Query(value = "{'_id': ?0}, { $unwind: '$operaciones' }, { $match: { 'operaciones.fecha': { $gte: ?1, $lt: ?2 } } }, { $project: { _id: 0, operaciones: 1 } }")
    //List<Operacion> findOperacionesByCuentaIdAndDateRange(String cuentaId, Date startDate, Date endDate);





    public long count();
}
