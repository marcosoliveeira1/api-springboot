package br.unisul.progweb.crudusers.domain;

import br.unisul.progweb.crudusers.domain.enums.Gender;
import br.unisul.progweb.crudusers.domain.enums.MaritalStatus;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Serialization
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String login;
    private String cpf;
    private LocalDate birthday;
    private Integer gender;
    private Integer maritalStatus;

    public User(Integer id, String name, String login, String cpf, LocalDate birthday, Gender gender, MaritalStatus maritalStatus) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.cpf = cpf;
        this.birthday = birthday;
        this.gender = (gender== null) ? null : gender.getId();
        this.maritalStatus = (maritalStatus== null) ? null : maritalStatus.getId();
    }
}
