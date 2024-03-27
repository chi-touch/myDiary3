package exceptions;

public class WrongEntryException extends RuntimeException{
    public WrongEntryException(String message){
        super(message);
    }
}
