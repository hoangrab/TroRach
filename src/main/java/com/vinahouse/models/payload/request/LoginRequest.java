package com.vinahouse.models.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message = "tai khoan khong duoc de trong nhe con")
    private String gmail;
    @NotBlank
    private String password;

    public LoginRequest() {

    }
    public LoginRequest(String gmail, String password) {
        this.gmail = gmail;
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String username) {
        this.gmail = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
