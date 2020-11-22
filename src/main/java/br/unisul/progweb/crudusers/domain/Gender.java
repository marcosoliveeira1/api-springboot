package br.unisul.progweb.crudusers.domain;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Serialization
public class Gender implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private boolean isActive;

}
