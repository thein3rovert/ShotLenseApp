package com.thein3rovert.shotLensApp.exception;

public class CustomApiException extends RuntimeException{
    public CustomApiException(String ExceptionMessage) { super (ExceptionMessage); }
    public CustomApiException() { super ("Error occurred"); }
}
