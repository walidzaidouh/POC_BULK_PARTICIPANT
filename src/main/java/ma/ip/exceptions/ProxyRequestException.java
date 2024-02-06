package ma.ip.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ProxyRequestException extends RuntimeException {
    public ProxyRequestException(Map<String, String> body, int status) {
        this.body = body;
        this.status = status;
    }
    int status;
    Map<String, String> body;

    @Override
    public String getMessage(){
        return "Error calling API Status " + status + " Body-" + body;
    }

    @Override
    public String getLocalizedMessage(){
        return "Error calling API Status " + status + "Body- " + body;
    }

}
