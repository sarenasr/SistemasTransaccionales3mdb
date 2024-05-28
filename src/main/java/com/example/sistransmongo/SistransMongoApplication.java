package com.example.sistransmongo;

import com.example.sistransmongo.model.*;
import com.example.sistransmongo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableMongoRepositories
public class SistransMongoApplication implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    OficinaRepository oficinaRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    PuntoAtencionRepository puntoAtencionRepository;

    @Autowired
    OperacionRepository operacionRepository;

    public static void main(String[] args) {
        SpringApplication.run(SistransMongoApplication.class, args);
    }

    public void run(String... args) throws Exception {

        boolean running = true;
        while(running){
            displayMenu();
            int option = Integer.parseInt(input("Enter your option:"));

            if(option == 1){
                System.out.println("Create User");
                String login = input("Enter login: ");
                String id = input("Enter id: ");
                String password = input("Enter password: ");
                String name = input("Enter name: ");
                String nationality = input("Enter nationality: ");
                String email = input("Enter email: ");
                String address = input("Enter address: ");
                String phone = input("Enter phone: ");
                String city = input("Enter city: ");
                String state = input("Enter state: ");
                String postalCode = input("Enter postal code: ");
                String idType = input("Enter id type: ");
                String personType = input("Enter person type: ");
                String userType = input("Enter user type: ");
                createUsuarioItems(login,id,password,name,nationality, email,address, phone, city, state, postalCode,
                        idType,personType,userType);
                System.out.println();
            }
            if(option == 2){
                System.out.println("---SHOW USUARIO ITEMS---\n");
                showAllUsuarios();
                System.out.println();
            }
            if(option == 3){
                System.out.println("---CREATE OFICINA ITEMS---\n");
                System.out.println("Create Office");
                String id = input("Enter id: ");
                String name = input("Enter name: ");
                String address = input("Enter address: ");
                int poi = Integer.parseInt(input("Enter poi: "));
                String adminName = input("Enter admin id: ");
                createOficinaItems(id, name, address, poi,adminName);
                System.out.println();
            }
            if(option == 4){
                System.out.println("---SHOW OFICINA ITEMS---\n");
                showAllOficinas();
                System.out.println();
            }
            if(option == 5){
                System.out.println("---CREATE POINT OF SERVICE---\n");
                String id = input("Enter id: ");
                String tipo = input("Enter type: ");
                String address = input("Enter address: ");
                String officeId = input("Enter office id (for digital enter dig): ");
                createPoint(id,tipo,address, officeId);

            }
            if(option == 6){
                System.out.println("---DELETE POINT OF SERVICE---\n");
                String id = input("Enter the point id: ");
                String officeId = input("Enter office id (for digital enter dig): ");
                deletePoint(id,officeId);
                System.out.println();
            }
            if(option == 7){
                System.out.println("---CREATE CUENTA---\n");
                String accountNumber = input("Enter accountNumber: ");
                String accountType = input("Enter accountType: ");
                double amount = Double.parseDouble(input("Enter the amount: "));
                String userName = input("Enter the id: ");
                createCuentaItems(accountNumber,accountType,amount,userName);
                System.out.println();
            }
            if(option == 8){
                System.out.println("---SHOW CUENTA ITEMS---\n");
                showAllCuentas();
                System.out.println();
            }
            if(option == 9){
                System.out.println("---UPDATE CUENTA ITEMS---\n");
                String id = input("Enter account id: ");
                updateCuentaState(id);
                showAllCuentas();
                System.out.println();
            }
            if(option == 10){
                System.out.println("---REGISTER OPERATION---\n");
                String operation = input("Choose operation \n 1. consignacion, 2. retiro, 3. transferencia ");
                switch(operation){
                    case "1":
                        String idCuenta = input("Enter account id: ");
                        Double valor = Double.parseDouble(input("Enter the value: "));
                        createConsignacion(idCuenta,valor);
                        break;
                    case "2":
                        String idRetiro = input("Enter account id: ");
                        Double valorRetiro = Double.parseDouble(input("Enter the value: "));
                        createRetiro(idRetiro,valorRetiro);
                        break;
                    case "3":
                        String idOrigen = input("Enter origin account id: ");
                        String idDestino = input("Enter destination account id: ");
                        Double valorTransferencia = Double.parseDouble(input("Enter the value: "));
                        createTransferencia(idOrigen,idDestino,valorTransferencia);
                        break;
                    default:
                        System.out.println("Error choosing operation!");
                }
            }
            if(option==11){
                int mes = Integer.parseInt(input("Ingrese el numero del mes: "));
                String id = input("Ingrese el id de la cuenta: ");
                //Date startDate = Date.from(fechaInicio.atZone(ZoneId.systemDefault()).toInstant());
                //Date endDate = Date.from(fechaFin.atZone(ZoneId.systemDefault()).toInstant());
                //List<Operacion> operaciones = cuentaRepository.findOperacionesByCuentaIdAndDateRange(id,startDate,endDate);

                createExtracto(id,mes);
            }

            if(option == 0){
                System.out.println("Goodbye");
                running = false;
                System.exit(0);
            }

        }
    }

    void createUsuarioItems(String login, String id, String password, String name , String nationality, String email, String address, String phone,
                            String city, String state, String postalCode, String idType, String personType, String userType){
        System.out.println("Usuario creation started...");
        usuarioRepository.save(new Usuario(login,id,password,name,nationality, email,address, phone, city, state, postalCode,
                            idType,personType,userType));
        System.out.println("Usuario creation completed...");
    }

    void createOficinaItems(String id, String name, String address, int poi, String Id){
        Random rand = new Random();
        Usuario admin = usuarioRepository.findUsuarioById(Id);
        List<PuntoAtencion> puntos = new ArrayList<>();
        for (int i = 0; i < poi; i++) {
            String idPunto = String.valueOf(rand.nextInt(100000));
            PuntoAtencion point = new PuntoAtencion(idPunto,"atencion personalizada", address);
            puntos.add(point);
        }
        puntoAtencionRepository.saveAll(puntos);
        System.out.println("Oficina creation started...");
        oficinaRepository.save(new Oficina(id,name,address,poi,admin,puntos));
        System.out.println("Oficina creation completed...");
    }

    void createCuentaItems(String accountNumber, String accountType, double amount,String Id){
        Usuario user = usuarioRepository.findUsuarioById(Id);
        List<Operacion> operaciones = new ArrayList<>();
        System.out.println("Cuenta creation started...");
        cuentaRepository.save(new Cuenta(accountNumber, accountType, amount, LocalDateTime.now(), true, user,operaciones));
        System.out.println("Cuenta creation completed...");
    }

    void createPoint(String id, String tipo, String localizacion, String idOficina){
        PuntoAtencion point = new PuntoAtencion(id,tipo,localizacion);
        if(!idOficina.equals("dig")){
            Oficina office = oficinaRepository.findOficinaById(idOficina);
            office.addPuntoAtencion(point);
            office.setPoi(office.getPoi()+1);
            oficinaRepository.save(office);
        }
        puntoAtencionRepository.save(point);
    }

    void createConsignacion(String id, double valor){
        Random rand = new Random();
        Operacion operacion = new Operacion(String.valueOf(rand.nextInt(100000000)),valor,LocalDateTime.now(),"consignacion",id,id);
        Cuenta cuenta = cuentaRepository.findCuentasById(id);
        cuenta.setAmount(cuenta.getAmount()+valor);
        cuenta.addOperacion(operacion);
        cuentaRepository.save(cuenta);
        operacionRepository.save(operacion);
    }

    void createRetiro(String id, double valor){
        Random rand = new Random();
        Operacion operacion = new Operacion(String.valueOf(rand.nextInt(100000000)),valor,LocalDateTime.now(),"retiro",id,id);
        Cuenta cuenta = cuentaRepository.findCuentasById(id);
        if(cuenta.getAmount()-valor >= 0){
            cuenta.setAmount(cuenta.getAmount()-valor);
            cuenta.addOperacion(operacion);
            cuentaRepository.save(cuenta);
            operacionRepository.save(operacion);
        }
        else{
            System.out.println("Not enough funds to perform!");
        }
    }

    void createTransferencia(String idOrigen, String idDestino, double valor){
        Random rand = new Random();
        Operacion operacion = new Operacion(String.valueOf(rand.nextInt(100000000)),valor,LocalDateTime.now(),"transferencia",idOrigen,idDestino);
        Cuenta cuentaOrigen = cuentaRepository.findCuentasById(idOrigen);
        Cuenta cuentaDestino = cuentaRepository.findCuentasById(idDestino);
        if(cuentaOrigen.getAmount()-valor >= 0){
            cuentaOrigen.setAmount(cuentaOrigen.getAmount()-valor);
            cuentaOrigen.addOperacion(operacion);
            cuentaDestino.setAmount(cuentaDestino.getAmount()+valor);
            cuentaDestino.addOperacion(operacion);
            cuentaRepository.save(cuentaOrigen);
            cuentaRepository.save(cuentaDestino);
            operacionRepository.save(operacion);
        }
        else{
            System.out.println("Not enough funds to perform!");
        }
    }

    void createExtracto(String id, int mes){
        LocalDateTime fechaInicio = getStartAndEndDatesForMonth(mes)[0];
        LocalDateTime fechaFin = getStartAndEndDatesForMonth(mes)[1];

        Cuenta cuenta = cuentaRepository.findCuentasById(id);
        //List<Operacion> operaciones = cuentaRepository.findOperacionesByCuentaIdAndDateRange(id,fechaInicio,fechaFin);
        List<Operacion> todasOperaciones = cuenta.getOperaciones();
        List<Operacion> operaciones = todasOperaciones.stream()
                .filter(op -> op.getFecha().compareTo(fechaInicio) >= 0 && op.getFecha().compareTo(fechaFin) < 0)
                .collect(Collectors.toList());


        System.out.println("Extracto creation started...\n");
        System.out.println("--- OPERACIONES ---");

        double saldoFinal = cuenta.getAmount();
        double saldoInicial = cuenta.getAmount();
        for ( Operacion operacion : operaciones) {
            if(operacion.getTipoOperacion().equals("consignacion")||(operacion.getCuentaSalida().equals(id)) && operacion.getTipoOperacion().equals("transferencia")){
                saldoInicial -= operacion.getValor();
            }
            if(operacion.getTipoOperacion().equals("retiro")){
                saldoInicial += operacion.getValor();
            }
            System.out.println(operacion);
        }
        System.out.println();
        System.out.println("Saldo Inicial: " + saldoInicial);
        System.out.println("Saldo Final: " + saldoFinal);

        System.out.println("Extracto creation completed...");

    }

    void deletePoint(String id, String idOficina){
        PuntoAtencion point = puntoAtencionRepository.findPuntoAtencionById(id);
        if(!idOficina.equals("dig")){
            Oficina office = oficinaRepository.findOficinaById(idOficina);
            office.removePuntoAtencion(point);
            oficinaRepository.save(office);
        }
        puntoAtencionRepository.delete(point);
    }

    public void showAllUsuarios(){
        usuarioRepository.findAll().forEach(System.out::println);
        System.out.println("---ALL USUARIOS ITEMS---\n");
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
        cuenta.setState(!cuenta.getState());
        cuentaRepository.save(cuenta);
    }

    //HELPER FUNCTIONS

    public LocalDateTime[] getStartAndEndDatesForMonth(int month) {
        int currentYear = LocalDateTime.now().getYear();

        // Start date is the first day of the given month at the start of the day
        LocalDateTime fechaInicio = LocalDateTime.of(currentYear, month, 1, 0, 0);

        // Use YearMonth to handle the end date of the month correctly
        YearMonth yearMonth = YearMonth.of(currentYear, month);
        LocalDateTime fechaFin = yearMonth.atEndOfMonth().atTime(23, 59, 59);

        return new LocalDateTime[]{fechaInicio, fechaFin};
    }

    public static String input(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static void displayMenu(){
        System.out.println("Menu Options:");
        System.out.println("1. Create a new user");
        System.out.println("2. Show all users");
        System.out.println("3. Create office");
        System.out.println("4. Show offices");
        System.out.println("5. Create point of service");
        System.out.println("6. Delete point");
        System.out.println("7. Create account");
        System.out.println("8. Show accounts");
        System.out.println("9. update account");
        System.out.println("10. register operation");
        System.out.println("11. generate bank statement");
        System.out.println("0. Exit");
    }


}
