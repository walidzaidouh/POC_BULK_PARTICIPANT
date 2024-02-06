package ma.ip.enums;

import ma.ip.exceptions.CustomerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

/**
 * The Enum MessageDirectionEnum.
 *
 * @author WZAIDOUH
 */
public enum MessageDirectionEnum {

    SEND("SEND"),

    RECEIVED("RECEIVED");

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageDirectionEnum.class);

    /**
     * The code.
     */
    private String code;

    /**
     * Instantiates a new action type enum.
     *
     * @param code the code
     */
    private MessageDirectionEnum(String code) {
        this.code = code;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Gets the type.
     *
     * @param typeName the type name
     * @return the type
     */
    public static MessageDirectionEnum getType(String typeName) {
        MessageDirectionEnum type = null;
        try {
            type = MessageDirectionEnum.valueOf(typeName.toUpperCase());
        } catch (IllegalArgumentException e) {
            String error = ConstantsEnum.MSG_ERREUR_CONVERSION_ENUM.getValue() + typeName;
            MessageDirectionEnum.LOGGER.error(error, e);
            throw new CustomerException(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (type == null) {
            String error = ConstantsEnum.MSG_ERREUR_CONVERSION_ENUM.getValue() + typeName;
            MessageDirectionEnum.LOGGER.error(error);
            throw new CustomerException(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return type;
    }

}
