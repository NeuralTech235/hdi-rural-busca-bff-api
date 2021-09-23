package com.hdi.ruralbuscabff.api.execptions;

public class EBaoSearchException extends RuntimeException{
    public EBaoSearchException() {
        super();
    }

    public EBaoSearchException(String message) {
        super(message);
    }

    public EBaoSearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public EBaoSearchException(Throwable cause) {
        super(cause);
    }

    protected EBaoSearchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
