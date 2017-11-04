package com.example.enums;

/**
 * Created by hx on 2017/11/4.
 */
public enum ResultEnum {
    UNKNONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    COLLEGE_STUDENT(100,"您是大学生吧"),
    GRADUATE_STUDENT(101,"您是研究生吧");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
