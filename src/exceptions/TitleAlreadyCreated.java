package exceptions;

public class TitleAlreadyCreated extends RuntimeException{
    public TitleAlreadyCreated(String message){
        super(message);
    }
}
