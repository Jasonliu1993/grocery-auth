package com.jwebcoder.groceryauth.common.dto;

/**
 * Created by Jason on 10/10/2017.
 */
public class ResponseMessage<T> {

    private int code;
    private String Message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
