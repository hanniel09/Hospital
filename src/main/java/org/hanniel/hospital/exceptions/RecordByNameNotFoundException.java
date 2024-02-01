package org.hanniel.hospital.exceptions;

public class RecordByNameNotFoundException extends RuntimeException{
    public RecordByNameNotFoundException(String model, String name){
        super(model + " not found or don't exist with name: " + name);
    }
}
