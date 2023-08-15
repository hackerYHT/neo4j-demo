package com.tao.neo4jdemo.resp;

import lombok.Data;

/**
 * @author hanxiantao
 */
@Data
public class WebResponse<T> {

    private boolean success;

    private T data;

    private String code;

    private String message;

    public WebResponse(boolean success, T data, String message) {
        this(success, data, message, null);
    }

    public WebResponse(boolean success, T data, String message, String code) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.code = code;
    }

    private static <T> WebResponse<T> createResponse(boolean success, T data, MessageTypeEnum messageType) {
        return createResponse(success, data, messageType.getName(), messageType.getCode());
    }

    private static <T> WebResponse<T> createResponse(boolean success, T data, String message, String code) {
        return new WebResponse(success, data, message, code);
    }

    public static <T> WebResponse<T> success(T data) {
        return createResponse(true, data, MessageTypeEnum.SUCCESS);
    }

    public static <T> WebResponse<T> success(T data, String message) {
        return createResponse(true, data, message, MessageTypeEnum.SUCCESS.getCode());
    }

    public static <T> WebResponse<T> success() {
        return createResponse(true, null, MessageTypeEnum.SUCCESS);
    }

    public static <T> WebResponse<T> fail(String message) {
        return createResponse(false, null, message, MessageTypeEnum.ERROR.getCode());
    }

    public static <T> WebResponse<T> fail() {
        return createResponse(false, null, MessageTypeEnum.ERROR);
    }

    public static <T> WebResponse<T> fail(T data, String message) {
        return createResponse(false, data, message, null);
    }

}
