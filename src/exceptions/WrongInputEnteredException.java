package exceptions;

public class WrongInputEnteredException extends RuntimeException{
    public WrongInputEnteredException(String message){
        super(message);
    }
}
