package br.unisul.progweb.crudusers;

import br.unisul.progweb.crudusers.domain.MaritalStatus;
import br.unisul.progweb.crudusers.repository.MaritalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CrudusersApplication implements CommandLineRunner {

    @Autowired
    MaritalStatusRepository maritalStatusRepository;

    public static void main(String[] args) {
        SpringApplication.run(CrudusersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MaritalStatus single = new MaritalStatus(null, "Solteiro(a)", true);
        MaritalStatus married = new MaritalStatus(null, "Casado(a)", true);
        MaritalStatus divorcied = new MaritalStatus(null, "Viúvo(a)", true);

        maritalStatusRepository.save(single);
        maritalStatusRepository.save(married);
        maritalStatusRepository.save(divorcied);
//        maritalStatusRepository.save(Arrays.asList(single, married, divorcied));
    }
}
