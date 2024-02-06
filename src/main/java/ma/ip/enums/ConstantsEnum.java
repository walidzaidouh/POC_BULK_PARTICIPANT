package ma.ip.enums;

/**
 * The enum ConstantsEnum.
 * @author WZAIDOUH
 */
public enum ConstantsEnum {

    /**
     * The cdm code banque.
     */
    DEFAULT_CODE_BANQUE("013"),

    CDM_CODE_BIC("BMCIMAMCXXX"),

    SPRING_PROFILE_DEVELOPMENT("dev"),

    SPRING_PROFILE_TEST("test"),

    SPRING_PROFILE_PRODUCTION("prod"),

    SPRING_PROFILE_CLOUD("cloud"),

    /**
     * The DAT E FORMA T dd mm yyyy.
     */
    DATE_FORMAT_CREATION_ISO("yyyy-MM-dd'T'HH:mm:ss.sss"),

    /**
     * The DAT E FORMA T dd mm yyyy.
     */
    DATE_FORMAT_YYYYMMDD("yyyyMMdd"),

    /**
     * The DATE FORMAT yyyy-mm-dd.
     */
    DATE_FORMAT_yyyy_mm_dd("YYYY-MM-DD"),

    /**
     * The msg erreur conversion enum.
     */
    MSG_ERREUR_CONVERSION_ENUM("ERREUR DE CONVERSION DE L'ENUM : "),

    /**
     * The DEFAULT CURRENCY.
     */
    DEFAULT_CURRENCY("MAD"),

    /** The DAT E FORMAT E D D M M yyyy 2. */
    DATE_FORMATE_DD_MM_yyyy_2("dd-MM-yyyy"), 
    
	/** The DAT E FORMAT E D D M M yyyy. */
	DATE_FORMATE_DD_MM_yyyy("dd/MM/yyyy"),

    PARTCIPANT_ENABLE("ACTF"),

    NATURE_ACCOUNT_MAD_CONV("NATURE_ACCOUNT_MAD_CONV"),

    ERROR_MSG_RIB_WRONG(" RIB not conform, please make sure one of them is correct"),

    ERROR_MSG_AMOUNT_CONVERSION(" Amount conversion error: "),

    ERROR_MSG_BENEFICIARY_REQUEST_IS_EMPTY(" Beneficiary Request is Empty."),

    ERROR_MSG_EMPTY_TRANSFER_DATE("Transfer date is not valid."),

    BALANCE_INEFFECTIVE("Your balance is insufficient to make this transfer"),

    /**
     * TRANSFER_PARAM_TRNASACTIONAK_OPTION_CHECK
     */
    ACCOUNT_TAX("25150110695"),

    /**
     * TRANSFER_PARAM_TRNASACTIONAK_OPTION_CHECK
     */
    TAX_CODE_BANQUE("001"),

    /**
     * TRANSFER_PARAM_TRNASACTIONAK_OPTION_CHECK
     */
    TAX_CODE_CITY("810"),

    /**
     * VIREMENT_ALREADY_EXECUTE.
     */
    TAX_ACCOUNT_UNAUTORIZE("The unauthorized DIR account"),

    /**
     * The customer has no transactionnal offer to execute a transfer.
     */
    VIREMENT_ACCOUNT_BENEFICIARY_IS_SAME_AS_TRANSMITER("Transfer of account on himself is prohibited."),

    /**
     * LIMIT_TRANSFER_EXCEED.
     */
    LIMIT_TRANSFER_EXCEED("Amount above the maximum threshold"),

    /**
     * LIMIT_TRANSFER_SUBCEED.
     */
    LIMIT_TRANSFER_SUBCEED("Amount below the minimum threshold"),

    ERROR_CALLING_SDK("Error during call SDK"),

    NUMBER_OF_TXS("1"),

    SVC_LVL("SDVA"),

    CHRG_BR("SLEV"),

    STTLM_MTD("CLRG");


    /**
     * The code.
     */
    private String value;

    /**
     * Instantiates a new constants enum.
     *
     * @param value the value
     */
    private ConstantsEnum(String value) {
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

}
