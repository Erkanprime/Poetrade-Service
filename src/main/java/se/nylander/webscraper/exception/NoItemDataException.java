package se.nylander.webscraper.exception;

/**
 * Created by Cody on 2016-04-21.
 */
public class NoItemDataException extends RuntimeException{

    public NoItemDataException(String message){
        super(message);
    }

    public NoItemDataException(String message, Exception e){ super(message, e.getCause()); }
}
