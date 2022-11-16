package com.kangkang.service.ex;

/**
 * ClassName:UsernameExistException
 * Package:com.kangkang.service.ex
 * Description:
 *
 * @date:2022/4/14 16:19
 * @author:kangkang
 */
public class ProductExistException extends ServiceException {
    public ProductExistException() {
        super();
    }

    public ProductExistException(String message) {
        super(message);
    }

    public ProductExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductExistException(Throwable cause) {
        super(cause);
    }

    protected ProductExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
