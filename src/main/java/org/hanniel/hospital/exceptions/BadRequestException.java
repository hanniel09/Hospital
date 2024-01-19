package org.hanniel.hospital.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String model, Long id){
        super(model + " not found or don't exist with id: " + id);
    }
}
