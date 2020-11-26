package br.unisul.progweb.crudusers.services;

import br.unisul.progweb.crudusers.domain.User;
import br.unisul.progweb.crudusers.domain.enums.Gender;
import br.unisul.progweb.crudusers.domain.enums.MaritalStatus;
import br.unisul.progweb.crudusers.dto.UserDTO;
import br.unisul.progweb.crudusers.dto.UserManagementDTO;
import br.unisul.progweb.crudusers.repository.UserRepository;
import br.unisul.progweb.crudusers.services.utils.DateFormat;
import br.unisul.progweb.crudusers.services.exceptions.ObjectNotFoundException;
import br.unisul.progweb.crudusers.services.exceptions.DataIntegrityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User findById(Integer id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! ID: "+id));
    }

    public User insert(User obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma User que possui produtos");
        }
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getLogin(), objDto.getCpf(), DateFormat.convertStringToLocalDate(objDto.getBirthday()), Gender.toEnum(objDto.getGender().getId()), MaritalStatus.toEnum(objDto.getMaritalStatus().getId()), null);
    }

    public User fromDTO(UserManagementDTO objDto) {
        return new User(null, objDto.getName(), objDto.getLogin(), objDto.getCpf(), DateFormat.convertStringToLocalDate(objDto.getBirthday()), Gender.toEnum(objDto.getGender().getId()), MaritalStatus.toEnum(objDto.getMaritalStatus().getId()), objDto.getPassword());
    }

    private void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setLogin(obj.getLogin());
        newObj.setCpf(obj.getCpf());
        newObj.setBirthday(obj.getBirthday());
        newObj.setPassword(obj.getPassword());
        newObj.setGender(Gender.toEnum(obj.getGender().getId()));
        newObj.setMaritalStatus(MaritalStatus.toEnum(obj.getMaritalStatus().getId()));
    }




}
