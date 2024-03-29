package am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.security;

import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.User;
import am.picsartacademy.springboot.cafeorderingsystemwithspringbootspringdataandsecure.entities.role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private final User user;
    private Role role;

    public UserPrincipal(User user) {
        this.user = user;
    }

    // Implement UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement as needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement as needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement as needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement as needed
    }
}

