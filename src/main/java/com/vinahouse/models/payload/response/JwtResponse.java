package com.vinahouse.models.payload.response;

import com.vinahouse.models.Role;

import java.util.List;

public class JwtResponse {
    private String jwt;
    private String gmail;
    private List<String> roleList;

    private int code;
    private int iduser;

    public JwtResponse(String jwt, String gmail, List<String> roleList, int code,int iduser) {
        this.jwt = jwt;
        this.gmail = gmail;
        this.roleList = roleList;
        this.code = code;
        this.iduser = iduser;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }


    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
}
