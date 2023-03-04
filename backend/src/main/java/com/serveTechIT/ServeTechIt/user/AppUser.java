package com.serveTechIT.ServeTechIt.user;

import com.serveTechIT.ServeTechIt.user.enums.AppUserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String userName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private boolean locked;
    private boolean enabled;

    public AppUser(String name, String userName, String email, String password, AppUserRole appUserRole) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = false;
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
