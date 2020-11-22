package br.unisul.progweb.crudusers;

import br.unisul.progweb.crudusers.domain.Gender;
import br.unisul.progweb.crudusers.domain.MaritalStatus;
import br.unisul.progweb.crudusers.domain.User;
import br.unisul.progweb.crudusers.repository.GenderRepository;
import br.unisul.progweb.crudusers.repository.MaritalStatusRepository;
import br.unisul.progweb.crudusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;


@SpringBootApplication
public class CrudusersApplication implements CommandLineRunner {

    @Autowired
    MaritalStatusRepository maritalStatusRepository;
    @Autowired
    GenderRepository genderRepository;
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
//        maritalStatusRepository.saveAll(Arrays.asList(single, married, divorcied));
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
