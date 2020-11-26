package br.unisul.progweb.crudusers.services.validations;

import br.unisul.progweb.crudusers.domain.User;
import br.unisul.progweb.crudusers.dto.UserManagementDTO;
import br.unisul.progweb.crudusers.repository.UserRepository;
import br.unisul.progweb.crudusers.resources.exceptions.FieldMessage;
import br.unisul.progweb.crudusers.services.utils.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserManagementValidator implements ConstraintValidator<UserManagement, UserManagementDTO> {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserRepository repo;

    @Override
    public void initialize(UserManagement ann) {
    }

    @Override
    public boolean isValid(UserManagementDTO objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = map.get("id") == null ? 0 : Integer.parseInt(map.get("id"));
        User aux = repo.findByLogin(objDto.getLogin());
        if (aux != null && !aux.getId().equals(uriId)) {
            list.add(new FieldMessage("login", "Login já existente"));
        }

        if(objDto.getPassword() != null && !objDto.getPassword().equals(objDto.getPasswordConfirmation())){
            list.add(new FieldMessage("passwordConfirmation", "As senhas precisam ser iguais"));
        }

        if(!DateFormat.isValid(objDto.getBirthday())) {
            list.add(new FieldMessage("birthday", "Data inválida"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}