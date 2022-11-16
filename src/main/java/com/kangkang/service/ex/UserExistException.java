package com.kangkang.service.ex;

/**
 * ClassName:UsernameExistException
 * Package:com.kangkang.service.ex
 * Description:
 *
 * @date:2022/4/14 16:19
 * @author:kangkang
 */
public class UserExistException extends ServiceException {
    public UserExistException() {
        super();
    }

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }

    protected UserExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
