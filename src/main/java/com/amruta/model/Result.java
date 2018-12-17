package com.amruta.model;

import java.util.List;

/**
 * Created by amrutaj on 17/12/2018.
 */
public class Result {

    private Boolean hasErrors;
    private String message;
    private String success;
    private String errorMessage;
    private Object object;


    public Boolean getHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(Boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return this.success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void addMessage(List<String> errorMessages) {
        errorMessages.stream().forEach((msg) -> {
            if (null == this.message) {
                this.message = "";
            }
            this.message += msg + "<br>";
        });
    }
}
