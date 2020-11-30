package br.unisul.progweb.crudusers.dto;

import br.unisul.progweb.crudusers.domain.User;
import br.unisul.progweb.crudusers.domain.enums.Gender;
import br.unisul.progweb.crudusers.domain.enums.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Integer id;

    @Length(message = "Nome precisa ter no minimo 5 digitos", min=5)
    private String name;

    @Length(message = "Login precisa ter no minimo 5 digitos", min=5)
    private String login;

    @Length(message = "CPF precisa ter 11 números", min=11, max=11)
    private String cpf;

    @NotNull(message = "Data de nascimento é um campo obrigatório")
    private String birthday;

    private Gender gender;

    private MaritalStatus maritalStatus;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public Gender getGender() {
        return gender;
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

//    public void setBirthday(String birthday) {
//        this.birthday = DateFormat.convertStringToLocalDate(birthday);
//    }

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.login = obj.getLogin();
        this.cpf = obj.getCpf();
        this.birthday = obj.getBirthday().toString();
        this.gender = obj.getGender();
        this.maritalStatus = obj.getMaritalStatus();
    }


}
