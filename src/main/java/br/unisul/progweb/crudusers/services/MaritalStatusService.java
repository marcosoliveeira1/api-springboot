package br.unisul.progweb.crudusers.services;

import br.unisul.progweb.crudusers.domain.MaritalStatus;
import br.unisul.progweb.crudusers.repository.MaritalStatusRepository;
import br.unisul.progweb.crudusers.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaritalStatusService {
    @Autowired
    private MaritalStatusRepository repo;

    public MaritalStatus findById(Integer id){
        Optional<MaritalStatus> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+id+", Tipo: Estado Civil"));
    }

    public MaritalStatus insert(MaritalStatus obj){
        obj.setId(null);

        return repo.save(obj);
    }
}
