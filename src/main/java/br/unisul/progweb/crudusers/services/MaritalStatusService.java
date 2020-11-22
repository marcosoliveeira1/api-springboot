package br.unisul.progweb.crudusers.services;

import br.unisul.progweb.crudusers.domain.MaritalStatus;
import br.unisul.progweb.crudusers.repository.MaritalStatusRepository;
import br.unisul.progweb.crudusers.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaritalStatusService {
    @Autowired
    private MaritalStatusRepository repo;

    public MaritalStatus findById(Integer id) {
        Optional<MaritalStatus> obj = repo.findById(id).filter(item -> item.isActive());

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id + ", Tipo: Estado Civil"));
    }

    public MaritalStatus insert(MaritalStatus obj) {
        obj.setId(null);

        return repo.save(obj);
    }

    public MaritalStatus update(MaritalStatus obj) {
        findById(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        MaritalStatus obj = findById(id);
        obj.setActive(false);
        repo.save(obj);
    }

    public List<MaritalStatus> findAll() {
        List<MaritalStatus> list = repo.findAll();
        return list;
    }

    public List<MaritalStatus> findAllActive() {
        List<MaritalStatus> filteredList = findAll().stream().filter(obj -> obj.isActive()).collect(Collectors.toList());
        return filteredList;
    }

}
