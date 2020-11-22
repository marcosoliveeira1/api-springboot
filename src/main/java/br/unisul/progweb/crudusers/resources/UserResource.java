package br.unisul.progweb.crudusers.resources;

import br.unisul.progweb.crudusers.domain.User;
import br.unisul.progweb.crudusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api/v1/user")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
