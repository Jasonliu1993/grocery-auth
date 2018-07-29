package com.jwebcoder.groceryauth.common.exception;

import com.jwebcoder.groceryauth.common.dto.ResponseMessage;
import com.jwebcoder.groceryauth.common.utils.PackingInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jason on 10/10/2017.
 */

@ControllerAdvice
public class CatchException {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ResponseMessage catchException(RuntimeException runtimeException) {

        if (runtimeException instanceof ErrorException) {
            return PackingInfo.changeException2Message((ErrorException) runtimeException);
        } else {
            runtimeException.printStackTrace();
            return PackingInfo.changeException2Message(new ErrorException(StatusCode.UNKNOWN));
        }

    }

}
