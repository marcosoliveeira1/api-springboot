package br.unisul.progweb.crudusers.services;

import br.unisul.progweb.crudusers.domain.User;
import br.unisul.progweb.crudusers.repository.UserRepository;
import br.unisul.progweb.crudusers.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User findById(Integer id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! ID: "+id));
    }
}
