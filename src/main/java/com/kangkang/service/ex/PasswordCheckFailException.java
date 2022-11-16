package com.kangkang.service.ex;

/**
 * ClassName:UsernameExistException
 * Package:com.kangkang.service.ex
 * Description:
 *
 * @date:2022/4/14 16:19
 * @author:kangkang
 */
public class PasswordCheckFailException extends ServiceException {
    public PasswordCheckFailException() {
        super();
    }

    public PasswordCheckFailException(String message) {
        super(message);
    }

    public PasswordCheckFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordCheckFailException(Throwable cause) {
        super(cause);
    }

    protected PasswordCheckFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
