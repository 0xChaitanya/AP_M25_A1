package Exceptions;

public class InsufficientFuelException extends Exception{
    public InsufficientFuelException() {};
    public InsufficientFuelException(String msg){
        super(msg);
    }
}
