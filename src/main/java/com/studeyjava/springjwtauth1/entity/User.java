package com.studeyjava.springjwtauth1.entity;
import jakarta.persistence.EnumType;
import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements  UserDetails{  
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ; 
    @Column(unique = true , nullable = false )
private String username ; 
@Column( nullable  = false )
private String password ;
@Enumerated(EnumType.STRING)
private RoleEnum role ;

public Collection<? extends GrantedAuthority > GrantedAuthorities(){
    //trả về quyền hạn của người dùng  dựa trên vai trò của họ 


    return List.of( new SimpleGrantedAuthority(role.name()));
}

//các phương thức khác của UserDetails
@Override
public String getUsername(){
   //trả về tên người dùng
    return username ; 
}
public String getPassword (){
return password ;
}
@Override
public boolean isAccountNonExpired(){
    return true ; // tài khoản không hết hạn 
}


@Override
public boolean isAccountNonLocked(){
    return true ; //tài khoàn không bị khóa
}   
@Override 
public boolean isCredentialsNonExpired(){
    return true ; // thông tin đăng nhập không hết hạn  và mật khẩu
}

@Override
public boolean isEnabled(){
    return true ; // tài khoản được kích hoạt 
}
public enum RoleEnum {
    ROLE_USER,
    ROLE_ADMIN
}
public Long getID(){
    return id ; 

}
public void setId(Long id){
    this.id = id ;
}
public void  setUsername(String username){
    this.username = username ;
}

public void setPassword ( String password){
    this.password = password ;
}
public void setRole ( RoleEnum role){
    this.role = role ;
}

public RoleEnum getRole(){
    return role ;
} 

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
}

}