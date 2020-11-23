package br.unisul.progweb.crudusers.resources;

import br.unisul.progweb.crudusers.domain.User;
import br.unisul.progweb.crudusers.domain.User;
import br.unisul.progweb.crudusers.dto.UserDTO;
import br.unisul.progweb.crudusers.resources.exceptions.helper.UriBuilder;
import br.unisul.progweb.crudusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;


@RestController
@RequestMapping(value="/api/v1/user")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping("/")
    public ResponseEntity<Void> insert(@Valid @RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = new UriBuilder(obj.getId()).getUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody UserDTO objDto, @PathVariable Integer id) {
        User obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<UserDTO>> findPage(
            @RequestParam(value="page", defaultValue="0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue="name") String orderBy,
            @RequestParam(value="direction", defaultValue="ASC") String direction) {
        Page<User> list = service.findPage(page, linesPerPage, orderBy, direction);
        Page<UserDTO> listDto = list.map(obj -> new UserDTO(obj));
        return ResponseEntity.ok().body(listDto);
    }

}
