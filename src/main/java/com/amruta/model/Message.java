package com.amruta.model;

import java.io.Serializable;

/**
 * Created by amrutaj on 09/12/2018.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = -7788619177798333712L;

    private String message;

    private String digest;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }
}
