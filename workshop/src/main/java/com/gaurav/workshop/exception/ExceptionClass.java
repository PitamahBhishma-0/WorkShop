package com.gaurav.workshop.exception;

import lombok.Data;

/**
 * @author bhishma<gaurav.basyal @ fonepay.com>
 */
@Data
public class ExceptionClass extends RuntimeException{

    private String message;

    public ExceptionClass(String message){
        this.message=message;
    }
}
