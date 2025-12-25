package com.studeyjava.springjwtauth1.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class AccessTokenResponse {
private String accessToken;
public AccessTokenResponse() {}
public AccessTokenResponse(String accesToken){
    this.accessToken = accessToken;
}
public String getAccessToken(){
    return accessToken;

}
public void setAccessToken(String accessToken){
    this.accessToken = accessToken;
}
    
}
