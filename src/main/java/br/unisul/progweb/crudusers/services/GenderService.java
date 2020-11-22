package br.unisul.progweb.crudusers.services;

import br.unisul.progweb.crudusers.domain.Gender;
import br.unisul.progweb.crudusers.repository.GenderRepository;
import br.unisul.progweb.crudusers.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderService {
    @Autowired
    private GenderRepository repo;

    public Gender findById(Integer id){
        Optional<Gender> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+id+", Tipo: Estado Civil"));
    }
}
