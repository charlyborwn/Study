package com.heavenhr.exception;

public class InvalidStatusException extends RuntimeException
{
    static final long serialVersionUID = -3387516993334229948L;


    public InvalidStatusException(String message)
    {
        super(message);
    }
}
