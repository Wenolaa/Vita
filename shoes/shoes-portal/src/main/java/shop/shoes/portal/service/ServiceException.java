package shop.shoes.portal.service;

import shop.shoes.portal.vo.R;

public class ServiceException extends RuntimeException{
    private int code = R.INTERNAL_SERVER_ERROR;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException(int code) {
        this.code = code;
    }

    public ServiceException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public ServiceException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ServiceException invalidRequest(String message) {
        return new ServiceException(message, R.INVALID_REQUEST);
    }

    public static ServiceException notFound(String message) {
        return new ServiceException(message, R.NOT_FOUND);
    }

    public static ServiceException gone(String message) {
        return new ServiceException(message, R.GONE);
    }

    public static ServiceException unprocesableEntity(String message) {
        return new ServiceException(message, R.UNPROCESABLE_ENTITY);
    }

}
