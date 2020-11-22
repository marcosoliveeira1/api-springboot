package br.unisul.progweb.crudusers.resources;

import br.unisul.progweb.crudusers.domain.MaritalStatus;
import br.unisul.progweb.crudusers.resources.exceptions.helper.UriBuilder;
import br.unisul.progweb.crudusers.services.MaritalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/maritalstatus")
public class MaritalStatusResource {

    @Autowired
    private MaritalStatusService service;

    @GetMapping("/")
    public ResponseEntity<List<MaritalStatus>> findAll() {
        List<MaritalStatus> list = service.findAllActive();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        MaritalStatus obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/")
    public ResponseEntity<Void> insert(@RequestBody MaritalStatus obj) {
        obj = service.insert(obj);
        URI uri = new UriBuilder(obj.getId()).getUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody MaritalStatus obj, @PathVariable Integer id) {
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
