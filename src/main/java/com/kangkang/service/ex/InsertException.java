package com.kangkang.service.ex;

/**
 * ClassName:UsernameExistException
 * Package:com.kangkang.service.ex
 * Description:
 *
 * @date:2022/4/14 16:19
 * @author:kangkang
 */
public class InsertException extends ServiceException {
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
