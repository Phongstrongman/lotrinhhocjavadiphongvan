package com.studeyjava.springjwtauth1.filter;
import java.io.IOException;
import lombok.Data;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import com.studeyjava.springjwtauth1.entity.User;
import com.studeyjava.springjwtauth1.service.jwtService;

@Component
@RequiredArgsConstructor
public class JwtService {
    
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Override 
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        
        String token = header.substring(7);
        
        
        try {
            String userName = jwtService.extractUsername(token, isRefresh:false);
            UserDetails user = userDetailsService.loadUserByUsername(username)
        UsernamePasswordAuthenticationToken authenToken =  new UsernamePasswordAuthenticationToken(User , null , user.getAuthorities());
        SecurityContext.getContext().setAuthentication(authenToken);
        } catch (Exception e) {
            // token sai hoặc hết hạn 
           
        }
        filterChain.doFilter(request, response);

    }
}