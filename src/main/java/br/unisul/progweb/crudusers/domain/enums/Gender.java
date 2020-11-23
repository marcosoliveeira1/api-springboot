package br.unisul.progweb.crudusers.domain.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE(0, "Masculino"),
    FEMALE(1, "Feminino"),
    ANOTHER(2, "Outro");

    private Integer id;
    private String name;

    
    public static Gender toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (Gender x : Gender.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + id);
    }
    
}
