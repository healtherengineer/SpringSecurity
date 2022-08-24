package com.egebarisan.SpringSecurity.auth;

import com.egebarisan.SpringSecurity.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetail implements UserDetails {

    //burda bir dto oluşturabilirdik kirapratik mimarisinde bi dto ile işlem yapıyoruz güvenlik açısından
    //nesnelere attribute düzeyinde erişim sağlıyor .
    private String name;
    private String password;
    private List<GrantedAuthority> roleList;

    public CustomUserDetail(User user) {
        this.name = user.getUsername();
        this.password = user.getPassword();
        this.roleList = user.getRoleList().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
