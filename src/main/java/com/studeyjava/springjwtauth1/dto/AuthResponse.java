package com.studeyjava.springjwtauth1.dto;

import lombok.Data;

@Data 

public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    public AuthResponse() {
    }
    public AuthResponse(String accessToken, String refreshToke){

        this.accessToken = accessToken; 
        this.refreshToken = refreshToken;


    }
    public String getAccessToken(){
        return accessToken;

    }

    public String getRefreshToken(){
        return refreshToken;
    }
    public void setAccessToken(String accessToken){
        this.accessToken = accessToken;
    }
    public void setRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
}