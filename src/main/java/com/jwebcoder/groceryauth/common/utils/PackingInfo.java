package com.jwebcoder.groceryauth.common.utils;


import com.jwebcoder.groceryauth.common.dto.ResponseMessage;
import com.jwebcoder.groceryauth.common.exception.ErrorException;
import com.jwebcoder.groceryauth.common.exception.StatusCode;

/**
 * Created by Jason on 10/10/2017.
 */
public class PackingInfo {

    public static ResponseMessage changeException2Message (ErrorException errorException) {
        ResponseMessage message = new ResponseMessage();

        message.setCode(errorException.getCode());
        message.setMessage(errorException.getMessage());

        return message;
    }

    public static ResponseMessage changeData2Message(Object object) {

        ResponseMessage message = new ResponseMessage();

        message.setCode(StatusCode.SUCCESSFUL.getCode());
        message.setMessage(StatusCode.SUCCESSFUL.getErrorMessage());
        message.setData(object);

        return message;
    }

}
