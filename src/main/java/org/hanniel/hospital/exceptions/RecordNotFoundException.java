package org.hanniel.hospital.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String model, Long doc){
        super(model + " not found or don't exist with reference: . " + doc);
    }
}
