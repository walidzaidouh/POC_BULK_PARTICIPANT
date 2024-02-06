package ma.ip.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public enum ErrorStatus {

    TECHNICAL_ERROR(500, "Une erreur technique est survenue. Veuillez réessayer ultérieurement."),
    FORBIDDEN_ERROR(403, "Demande interdite par les règles administratives. Merci de contacter le support");


    private static final Logger logger = LoggerFactory.getLogger(ErrorStatus.class);

    private int code;
    private String desctiption;

    private ErrorStatus(int code, String desctiption) {
        setCode(code);
        setDesctiption(desctiption);
    }

    public int code() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String description() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }


}
