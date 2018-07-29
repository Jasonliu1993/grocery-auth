package com.jwebcoder.groceryauth.common.dto;

/**
 * Created by Jason on 17/10/2017.
 */
public class AuthInfoDTO {
    private String object;
    private String errorFlag;
    private String errorMessage;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getErrorFlag() {
        return errorFlag;
    }

    public void setErrorFlag(String errorFlag) {
        this.errorFlag = errorFlag;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
