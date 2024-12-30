package ecommercespringlabs.springbootlabslab4.service.exception;

public class NewsItemNotFoundException extends RuntimeException{
    public static final String News_NOT_FOUND_MESSAGE = "News with ID %s Not found";
    public NewsItemNotFoundException(String id) {
        super(String.format(News_NOT_FOUND_MESSAGE, id));
    }
}
