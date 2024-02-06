package ma.ip.exceptions;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class CustomerException extends RuntimeException {

    private String message;
    private String code;
    private HttpStatus httpStatus;
    private boolean isAlert = true;

    public CustomerException(String message) {
        super();
        this.message = message;
    }

    public CustomerException(String message, boolean isAlert) {
        super();
        this.message = message;
        this.isAlert = isAlert;
    }

    public CustomerException(String message, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public CustomerException(String message, String code, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public CustomerException(String message, String code, HttpStatus httpStatus, boolean isAlert) {
        super();
        this.message = message;
        this.code = code;
        this.httpStatus = httpStatus;
        this.isAlert = isAlert;
    }
}
