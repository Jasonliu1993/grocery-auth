package com.jwebcoder.groceryauth.common.exception;

/**
 * Created by Jason on 10/10/2017.
 */
public class ErrorException extends RuntimeException {

    private int code;

    public ErrorException(StatusCode statusCode) {
        super(statusCode.getErrorMessage());
        this.code = statusCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
