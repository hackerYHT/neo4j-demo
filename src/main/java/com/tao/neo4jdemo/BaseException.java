package com.tao.neo4jdemo;

import com.tao.neo4jdemo.resp.MessageTypeEnum;

/**
 * @author hanxiantao
 */
public class BaseException extends RuntimeException {

    private MessageTypeEnum msgType = MessageTypeEnum.UNKNOWN;

    public BaseException(MessageTypeEnum msgType) {
        this.msgType = msgType;
    }

    public BaseException(MessageTypeEnum msgType, Throwable cause) {
        super(cause);
        this.msgType = msgType;
    }

    public BaseException(MessageTypeEnum msgType, String message) {
        super(message);
        this.msgType = msgType;
    }

    public BaseException(MessageTypeEnum msgType, Throwable cause, String message) {
        super(message, cause);
        this.msgType = msgType;
    }

    public BaseException(MessageTypeEnum msgType, String details, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(details, cause, enableSuppression, writableStackTrace);
        this.msgType = msgType;
    }

    public static BaseException newException(MessageTypeEnum msgType, String message, Object... params) {
        BaseException sre;
        if (params != null && params.length > 0) {
            String formatMessage = String.format(message, params);
            if (params[params.length - 1] instanceof Throwable) {
                sre = new BaseException(msgType, (Throwable) params[params.length - 1], formatMessage);
            } else {
                sre = new BaseException(msgType, formatMessage);
            }
        } else {
            sre = new BaseException(msgType, message);
        }
        return sre;
    }

    public static BaseException newException(MessageTypeEnum msgType, String message) {
        return new BaseException(msgType, message);
    }

    public static BaseException newErrorException(String message) {
        return new BaseException(MessageTypeEnum.ERROR, message);
    }

    public static void throwNewException(MessageTypeEnum msgType, String message) {
        throw BaseException.newException(msgType, message);
    }

    public static void throwNewErrorException(String message) {
        throw BaseException.newErrorException(message);
    }

    public MessageTypeEnum getMessageType() {
        return this.msgType;
    }

}
