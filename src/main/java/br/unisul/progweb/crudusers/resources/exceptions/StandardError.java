package br.unisul.progweb.crudusers.resources.exceptions;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Serialization
public class StandardError implements Serializable {
    private Integer status;
    private String msg;
    private Long timeStamp;
}
