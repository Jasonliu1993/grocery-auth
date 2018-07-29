package com.jwebcoder.groceryauth.common.exception;

/**
 * Created by Jason on 10/10/2017.
 */
public enum StatusCode {

    UNKNOWN(-1, "未知错误"),
    SUCCESSFUL(100,"成功"),
    FAILED(101, "内部错误"),
    NULL_FILE(102,"文件不能为空"),
    FAILED_UPLOAD(103,"文件上传失败"),
    SUCCESSFUL_UPLOAD(104,"文件上传成功")
    ;

    private int code;
    private String errorMessage;

    StatusCode(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
