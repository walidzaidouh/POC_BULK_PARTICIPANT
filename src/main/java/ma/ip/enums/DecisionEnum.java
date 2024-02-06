package ma.ip.enums;


import ma.ip.exceptions.CustomerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;


public enum DecisionEnum {

    // PAYEMENT
    ACPT("ACPT", "ACPT"),

    ACCP("ACCP", "ACCP"),

    ACSP("ACSP", "ACSP"),

    ACSC("ACSC", "ACSC"),

    RJCT("RJCT", "RJCT"),

    ACCC("ACCC", "ACCC"),
    // PENDING
    PNDG("PNDG", "PNDG"),

    START("START", "START");

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DecisionEnum.class);

    /**
     * The code.
     */
    private String code;

    /**
     * The value.
     */
    private String value;


    /**
     * Instantiates a new constants enum.
     *
     *
     *
     * @param value the value
     */
    private DecisionEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String value() {
        return this.value;
    }

    /**
     * Gets the code
     *
     * @return the code
     */
    public String code() {
        return this.code;
    }

    /**
     * Gets the type.
     *
     * @param code the type name
     * @return the type
     */
    public static DecisionEnum getDecision(String code) {
        DecisionEnum decisionEnum = null;
        try {
            decisionEnum = DecisionEnum.valueOf(code.toUpperCase());
        } catch (IllegalArgumentException e) {
            String error = ConstantsEnum.MSG_ERREUR_CONVERSION_ENUM.getValue() + code;
            DecisionEnum.LOGGER.error(error, e);
            throw new CustomerException(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (decisionEnum == null) {
            String error = ConstantsEnum.MSG_ERREUR_CONVERSION_ENUM.getValue() + code;
            DecisionEnum.LOGGER.error(error);
            throw new CustomerException(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return decisionEnum;
    }

}
