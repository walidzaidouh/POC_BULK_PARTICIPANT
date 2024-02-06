package ma.ip.dto.responses;

import lombok.Data;

import java.io.Serializable;

@Data
public class GenericResponse implements Serializable {

    private String statusCode;
    private boolean error;
    private boolean alert = true;
    private String description;
    private String descriptionForCustomer;
}
