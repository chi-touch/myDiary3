package exceptions;

public class InvalidPassWordException extends RuntimeException{
    public InvalidPassWordException(String message){
        super(message);
    }
}
