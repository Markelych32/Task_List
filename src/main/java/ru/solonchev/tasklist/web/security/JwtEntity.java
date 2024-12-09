package ru.solonchev.tasklist.web.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@AllArgsConstructor
@Builder
public class JwtEntity implements UserDetails {

    private Long id;
    private String name;
    private String username;
    private String password;
    private final Collection<? extends GrantedAuthority> authorities;

}
