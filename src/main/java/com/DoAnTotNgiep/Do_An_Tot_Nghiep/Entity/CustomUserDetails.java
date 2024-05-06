package com.DoAnTotNgiep.Do_An_Tot_Nghiep.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private Collection<? extends GrantedAuthority> authorities;
    private User user;

    public CustomUserDetails(User user, Collection<GrantedAuthority> grantedAuthoritySet) {
        this.user=user;
        this.authorities=grantedAuthoritySet;
    }

    public CustomUserDetails(User user) {
        this.user=user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        if (this.user != null) {
            return this.user.getUsername();
        }
        return null;
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
