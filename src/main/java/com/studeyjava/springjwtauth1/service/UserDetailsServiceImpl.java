package com.studeyjava.springjwtauth1.service;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collections;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.studeyjava.springjwtauth1.repository.UserRepository;//import repository
import com.studeyjava.springjwtauth1.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
  return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
    user.getPassword(),
    Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()
)
       )
    );     }
        
}
