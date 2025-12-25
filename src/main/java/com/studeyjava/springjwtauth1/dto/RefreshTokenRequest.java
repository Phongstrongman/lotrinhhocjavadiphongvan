package com.studeyjava.springjwtauth1.dto;
import lombok.Data;


@Data

public class RefreshTokenRequest {
    private String refreshToken;
     private String ArefreshToken ; 
    public RefreshTokenRequest(String refreshToken){
         this.refreshToken = refreshToken;   
        }
        public RefreshTokenRequest(){}
    public String getRefreshToken(){
        return refreshToken;
    }   
    public void setRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
} 
