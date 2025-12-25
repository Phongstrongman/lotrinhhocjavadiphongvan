package com.studeyjava.springjwtauth1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studeyjava.springjwtauth1.dto.AccessTokenResponse;
import com.studeyjava.springjwtauth1.dto.AuthResponse;
import com.studeyjava.springjwtauth1.dto.LoginRequest;
import com.studeyjava.springjwtauth1.dto.RefreshTokenRequest;

import com.studeyjava.springjwtauth1.service.jwtService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("auth")// này là đường dẫn đến controller
public class AuthController {
    @Autowired 
    private AuthenticationManager authenticationManager;
    @Autowired 
    private jwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
@org.springframework.web.bind.annotation.GetMapping("/encode/{password}")
public String encodePassword (@org.springframework.web.bind.annotation.PathVariable String password ) {
    return passwordEncoder.encode(password) ;
}
 @PostMapping("/Login")
 public ResponseEntity<?>login (@RequestBody LoginRequest request){
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()) 
    );
    UserDetails user = (UserDetails) authentication.getPrincipal();
    ;
    String accessToken = jwtService.generrateAccessToken(user);
    String refreshToken = jwtService.generrateRefreshToken(user);
    return ResponseEntity.ok(new AuthResponse(accessToken, refreshToken)); 
 
 }
 @PostMapping("/refresh")
 public  ResponseEntity<?> postMethodName(@RequestBody RefreshTokenRequest request) {
        String username = jwtService.extractUsername(request.getRefreshToken(),true);
     //TODO: process POST request
     UserDetails user = userDetailsService.loadUserByUsername(username);
          String newAccessToken = jwtService.generrateAccessToken(user);
      return  ResponseEntity.ok (new AccessTokenResponse(newAccessToken));
 }
 
}