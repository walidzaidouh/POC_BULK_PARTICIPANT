package ma.ip.enums;

import ma.ip.exceptions.CustomerException;
import org.springframework.http.HttpStatus;

public enum CanalEnum {

    MOBILE("MOBILE", "MB"),
    AGENCY("AGENCY", "AG"),
    EBANKING_RETAIL("EBANKING_RETAIL", "EB"),
    EBANKING_CORPO("EBANKING_CORPO", "CR"),
    CSM("CSM", "CSM");

    /**
     * The code.
     */
    private String code;

    /**
     * The shortCode.
     */
    private String shortCode;

    private CanalEnum(String code, String shortCode) {
        this.code = code;
        this.shortCode = shortCode;
    }

    public String code() {
        return code;
    }

    public String shortCode() {return shortCode;}

    /**
     * Gets the type.
     *
     * @param code the type name
     * @return the type
     */
    public static CanalEnum getChannel(String code) {
        CanalEnum channel = null;
        try {
            channel = CanalEnum.valueOf(code.toUpperCase());
        } catch (IllegalArgumentException e) {
            String error = ConstantsEnum.MSG_ERREUR_CONVERSION_ENUM.getValue() + code;
            throw new CustomerException(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (channel == null) {
            String error = ConstantsEnum.MSG_ERREUR_CONVERSION_ENUM.getValue() + code;
            throw new CustomerException(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return channel;
    }


}
