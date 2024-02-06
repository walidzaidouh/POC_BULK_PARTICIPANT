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
public enum MessageStatusEnum {

    OK("queue.send.ok"),

    INPROGRESS("queue.send.inprogress"),

    NOT_DEPOSITED("queue.send.notdeposed"),

    UNCOMMITTED("queue.send.uncommited"),

    NOT_VALIDE("queue.send.not.valide"),

    NOT_CONNECTED("queue.send.not.connected");

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageStatusEnum.class);

    /**
     * The code.
     */
    private String code;

    /**
     * Instantiates a new action type enum.
     *
     * @param code the code
     */
    private MessageStatusEnum(String code) {
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
    public static MessageStatusEnum getType(String typeName) {
        MessageStatusEnum type = null;
        try {
            type = MessageStatusEnum.valueOf(typeName.toUpperCase());
        } catch (IllegalArgumentException e) {
            String error = ConstantsEnum.MSG_ERREUR_CONVERSION_ENUM.getValue() + typeName;
            MessageStatusEnum.LOGGER.error(error, e);
            throw new CustomerException(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (type == null) {
            String error = ConstantsEnum.MSG_ERREUR_CONVERSION_ENUM.getValue() + typeName;
            MessageStatusEnum.LOGGER.error(error);
            throw new CustomerException(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return type;
    }

}
