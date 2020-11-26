package br.unisul.progweb.crudusers.domain.enums;


import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaritalStatus {

    SINGLE(0, "Solteiro(a)"),
    MARRIED(1, "Casado(a)"),
    WIDOWED(2, "Viúvo(a)"),
    DIVORCED(3, "Divorciado(a)"),
    ANOTHER(4, "Outro");

    private Integer id;
    private String name;

    public static MaritalStatus toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (MaritalStatus x : MaritalStatus.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + id);
    }

    @JsonValue
    public String getName() {
        return name;
    }

}
