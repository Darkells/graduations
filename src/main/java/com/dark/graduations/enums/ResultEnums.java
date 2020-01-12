package com.dark.graduations.enums;

public enum  ResultEnums {
    /**
     * 通用登陆状态码
     */
    LOGIN_SUCCESS(0, "登陆成功"),
    LOGIN_ACCOUNT(1, "帐号不存在"),
    LOGIN_PASSWORD(2, "密码错误");

    private Integer code;

    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultEnums{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
