package com.kangkang.service.ex;

/**
 * ClassName:UsernameExistException
 * Package:com.kangkang.service.ex
 * Description:
 *
 * @date:2022/4/14 16:19
 * @author:kangkang
 */
public class PhoneException extends ServiceException {
    public PhoneException() {
        super();
    }

    public PhoneException(String message) {
        super(message);
    }

    public PhoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneException(Throwable cause) {
        super(cause);
    }

    protected PhoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
