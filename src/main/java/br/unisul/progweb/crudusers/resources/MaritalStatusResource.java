package br.unisul.progweb.crudusers.resources;

import br.unisul.progweb.crudusers.domain.MaritalStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/maritalstatus")
public class MaritalStatusResource {

    @GetMapping("/")
    public List<MaritalStatus> get(){

        MaritalStatus single = new MaritalStatus(1, "Single", true);
        MaritalStatus married = new MaritalStatus(1, "Married", true);

        List<MaritalStatus> list = new ArrayList<>();
        list.add(single);
        list.add(married);


        return list;
    }
}
