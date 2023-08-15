package com.tao.neo4jdemo.resp;

/**
 * @author hanxiantao
 */
public enum MessageTypeEnum {
    SUCCESS("1", "请求成功完成。"),

    ERROR("0", "发现错误。"),

    UNKNOWN("-4", "未知错误。");

    private String code;
    private String text;

    MessageTypeEnum(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.text;
    }
}
