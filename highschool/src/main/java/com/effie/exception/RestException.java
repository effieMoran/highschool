package com.effie.exception;

/**
 * Created by effie on 11/21/15.
 */
public class RestException extends RuntimeException{
    private int code;
    private String message;
    private String detailedMessage;

    public RestException(int code, String message, String detailedMessage) {
        this.code = code;
        this.message = message;
        this.detailedMessage = detailedMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }
}
