package br.unisul.progweb.crudusers.domain;

import br.unisul.progweb.crudusers.domain.enums.Gender;
import br.unisul.progweb.crudusers.domain.enums.MaritalStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
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
    private String password;

    public User(Integer id, String name, String login, String cpf, LocalDate birthday, Gender gender, MaritalStatus maritalStatus, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.cpf = cpf;
        this.birthday = birthday;
        this.gender = (gender == null) ? null : gender.getId();
        this.maritalStatus = (maritalStatus == null) ? null : maritalStatus.getId();
        this.password = password;

    }
    
    public Gender getGender() {
        return Gender.toEnum(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender.getId();
    }

    public MaritalStatus getMaritalStatus() {
        return MaritalStatus.toEnum(maritalStatus);
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus.getId();
    }


}
