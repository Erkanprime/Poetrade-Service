package se.nylander.webscraper.exception;

/**
 * Created by Cody on 2016-05-24.
 */
public class UnknownBaseTypeException extends RuntimeException {

    public UnknownBaseTypeException(String message){
        super(message);
    }

    public UnknownBaseTypeException(String message, Exception e){ super(message, e.getCause()); }
}
