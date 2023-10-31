package com.vinahouse.models.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest {

    @NotBlank
    @Size(max = 50)
    private String name;
    @NotBlank
    @Size(max = 30)
    private String gmail;
    @NotBlank
    @Size(max = 50)
    private String password;
    @NotBlank
    @Size(max = 20)
    private String phone;

    public SignupRequest(String name,String gmail, String password, String sdt) {
        this.name = name;
        this.gmail = gmail;
        this.password = password;
        this.phone = sdt;
    }

    public SignupRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String sdt) {
        this.phone = sdt;
    }
}
