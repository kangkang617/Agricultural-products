package com.kangkang.service.ex;

/**
 * ClassName:UsernameExistException
 * Package:com.kangkang.service.ex
 * Description:
 *
 * @date:2022/4/14 16:19
 * @author:kangkang
 */
public class FarmerExistException extends ServiceException {
    public FarmerExistException() {
        super();
    }

    public FarmerExistException(String message) {
        super(message);
    }

    public FarmerExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FarmerExistException(Throwable cause) {
        super(cause);
    }

    protected FarmerExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
