package com.vinahouse.models.payload.response;

public class MessageResponse {

    private int code;
    private String mess;

    public MessageResponse(String mess, int code) {
        this.mess = mess;
        this.code = code;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
