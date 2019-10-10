package com.pnc.training.StackOverflow.Exception;

public class StackOverFlowEx extends Throwable {
    String statusCode;
    String message;

    public StackOverFlowEx(){}

    public StackOverFlowEx (String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }


    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
