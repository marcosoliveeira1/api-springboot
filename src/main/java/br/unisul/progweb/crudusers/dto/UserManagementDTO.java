package br.unisul.progweb.crudusers.dto;

import br.unisul.progweb.crudusers.domain.User;
import br.unisul.progweb.crudusers.services.validations.UserManagement;
import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Serialization
@UserManagement
public class UserManagementDTO extends UserDTO implements Serializable  {

    @Length(message = "Nome precisa ter no minimo 5 digitos", min=5)
    private String password;
    private String passwordConfirmation;

    public UserManagementDTO(User obj) {
        super(obj);
        this.password = obj.getPassword();
        System.out.println(this);
    }
}
