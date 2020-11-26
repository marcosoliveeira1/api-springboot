package br.unisul.progweb.crudusers.services.utils;

import br.unisul.progweb.crudusers.services.exceptions.DataIntegrityException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateFormat {
    public static LocalDate convertStringToLocalDate(String s){
        try {
            LocalDate localDate = LocalDate.parse(s);
            return localDate;
        } catch (DateTimeParseException e){
            throw new DataIntegrityException("Data inválida",e);
        }
    }

    public static Boolean isValid(String s){
        try {
            LocalDate localDate = LocalDate.parse(s);
        } catch (DateTimeParseException e){
            return false;
        }
        return true;
    }




}
