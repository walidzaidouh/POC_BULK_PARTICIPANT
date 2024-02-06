package ma.ip.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum FlowEnum {



    PACS008("pacs.008"),

    PACS002("pacs.002"),

    PACS028("pacs.028"),

    UNKNOWN("UNKNOWN");



    private static final Logger logger = LoggerFactory.getLogger(FlowEnum.class);

    private String msgType;

    private FlowEnum(String msgType) {
        this.msgType = msgType;

    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
