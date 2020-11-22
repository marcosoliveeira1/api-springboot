package br.unisul.progweb.crudusers.resources.exceptions;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Serialization
public class FieldMessage implements Serializable {
    private String fieldName;
    private String message;
}
