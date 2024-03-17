package exceptions;

public class DivisionPorCeroException  extends RuntimeException{
    public DivisionPorCeroException(String message) {
        super(message);
    }
}