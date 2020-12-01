package br.unisul.progweb.crudusers;

import br.unisul.progweb.crudusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudusersApplication implements CommandLineRunner {
    
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(CrudusersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        MaritalStatus single = new MaritalStatus(null, "Solteiro(a)", true);
//        MaritalStatus married = new MaritalStatus(null, "Casado(a)", true);
//        MaritalStatus divorcied = new MaritalStatus(null, "Viúvo(a)", true);
//        MaritalStatus ms1 = new MaritalStatus(null, "Separado(a) judicialmente", true);
//        MaritalStatus ms2 = new MaritalStatus(null, "Em união estável", true);
//        maritalStatusRepository.saveAll(Arrays.asList(single, married, divorcied));
//        maritalStatusRepository.saveAll(Arrays.asList(ms1, ms2));
//
//
//        Gender male = new Gender(null, "Masculino", true);
//        Gender female = new Gender(null, "Feminino", true);
//        genderRepository.saveAll(Arrays.asList(male, female));
//
//        User user1 = new User(null, "Marcos Oliveira", "marcosmoj", "09075681909", LocalDate.of(2020,10,29), male, single);
//        User user2 = new User(null, "Rosangela Maring", "rosangelarm", "00000000000", LocalDate.of(1975,12,31), female, married);
//
//        userRepository.saveAll(Arrays.asList(user1, user2));




    }
}
