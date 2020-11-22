package br.unisul.progweb.crudusers.resources;

import br.unisul.progweb.crudusers.domain.MaritalStatus;
import br.unisul.progweb.crudusers.resources.exceptions.helper.UriBuilder;
import br.unisul.progweb.crudusers.services.MaritalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value="/api/v1/maritalstatus")
public class MaritalStatusResource {

    @Autowired
    private MaritalStatusService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        MaritalStatus obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/")
    public ResponseEntity<Void> insert(@RequestBody MaritalStatus obj){
        obj = service.insert(obj);
        URI uri = new UriBuilder(obj.getId()).getUri();

        return ResponseEntity.created(uri).build();
    }
}
