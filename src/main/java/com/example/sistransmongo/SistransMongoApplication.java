package com.example.sistransmongo;

import com.example.sistransmongo.model.Cuenta;
import com.example.sistransmongo.model.Oficina;
import com.example.sistransmongo.model.Usuario;
import com.example.sistransmongo.repository.CuentaRepository;
import com.example.sistransmongo.repository.OficinaRepository;
import com.example.sistransmongo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableMongoRepositories
public class SistransMongoApplication implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    OficinaRepository oficinaRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SistransMongoApplication.class, args);
    }

    public void run(String... args) throws Exception {
        System.out.println("---CREATE USUARIO ITEMS---\n");
        createUsuarioItems();
        System.out.println();

        System.out.println("---SHOW USUARIO ITEMS---\n");
        showAllUsuarios();
        System.out.println();

        System.out.println("---CREATE OFICINA ITEMS---\n");
        createOficinaItems();
        System.out.println();

        System.out.println("---SHOW OFICINA ITEMS---\n");
        showAllOficinas();
        System.out.println();

        System.out.println("---CREATE CUENTA ITEMS---\n");
        createCuentaItems();
        System.out.println();

        System.out.println("---SHOW CUENTA ITEMS---\n");
        showAllCuentas();
        System.out.println();

        System.out.println("---UPDATE CUENTA ITEMS---\n");
        updateCuentaState("12345678");
        showAllCuentas();
        System.out.println();
    }

    void createUsuarioItems(){
        System.out.println("Usuario creation started...");
        usuarioRepository.save(new Usuario("admin","123","password","administrador","Colombia",
                "admin@gmail.com","Calle 19 #2a-10", "315604813", "Bogota", "Bogota D.C", "68001",
                "Cedula","Natural","Gerente General"));
        System.out.println("Usuario creation completed...");
    }

    void createOficinaItems(){
        Usuario admin = new Usuario("s.arenasr","124","contra","Santiago Arenas","Colombia",
                "s.arenasr@uniandes.edu.co","Cra 17a #103-24", "3187756680","Bucaramanga","Santander",
                "61001","Cedula","Natura","Gerente General");
        System.out.println("Oficina creation started...");
        oficinaRepository.save(new Oficina("123","Centro","Calle 10 #1-20",5,admin));
        System.out.println("Oficina creation completed...");
    }

    void createCuentaItems(){
        Usuario admin = new Usuario("s.arenasr","124","contra","Santiago Arenas","Colombia",
                "s.arenasr@uniandes.edu.co","Cra 17a #103-24", "3187756680","Bucaramanga","Santander",
                "61001","Cedula","Natura","Gerente General");
        System.out.println("Cuenta creation started...");
        cuentaRepository.save(new Cuenta("12345678","Ahorros",100000.0, LocalDateTime.now(),true,admin));
        System.out.println("Cuenta creation completed...");
    }

    public void showAllUsuarios(){
        usuarioRepository.findAll().forEach(System.out::println);
    }

    public void showUsuarioById(String id){
        usuarioRepository.findById(id).ifPresent(System.out::println);
    }

    public void findCountUsuarios(){
        long count = usuarioRepository.count();
        System.out.println("Numero de usuarios: " +count);
    }

    public void showAllOficinas(){
        oficinaRepository.findAll().forEach(System.out::println);
    }

    public void showAllCuentas(){
        cuentaRepository.findAll().forEach(System.out::println);
    }

    public void updateCuentaState(String id){
        Cuenta cuenta = cuentaRepository.findById(id).get();
        cuenta.setState(false);
        cuentaRepository.save(cuenta);
    }




}
