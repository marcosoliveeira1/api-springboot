package br.unisul.progweb.crudusers.services;

import br.unisul.progweb.crudusers.domain.MaritalStatus;
import br.unisul.progweb.crudusers.repository.MaritalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaritalStatusService {
    @Autowired
    private MaritalStatusRepository repo;

    public MaritalStatus findById(Integer id){
        Optional<MaritalStatus> obj = repo.findById(id);
        return obj.orElse(null);
    }
}
