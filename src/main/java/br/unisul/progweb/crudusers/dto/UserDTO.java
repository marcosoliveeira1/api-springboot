package br.unisul.progweb.crudusers.dto;

import br.unisul.progweb.crudusers.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDTO {
    private Integer id;

    @NotEmpty(message = "Prenchimento obrigatório")
    private String name;

    @NotEmpty(message = "Prenchimento obrigatório")
    private String login;

    @NotEmpty(message = "Prenchimento obrigatório")
    @Size(min = 11, max = 11, message = "CPF inválido")
    private String cpf;

    @NotEmpty(message = "Prenchimento obrigatório")
    private LocalDate birthday;

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.login = obj.getLogin();
        this.cpf = obj.getCpf();
        this.birthday = obj.getBirthday();
    }


}
