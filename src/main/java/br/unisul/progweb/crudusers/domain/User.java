package br.unisul.progweb.crudusers.domain;

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
@AllArgsConstructor
@Serialization
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String login;
    private String cpf;
    private LocalDate birthday;

    @ManyToOne()
    private Gender gender;

    @ManyToOne()
    private MaritalStatus maritalStatus;
}
