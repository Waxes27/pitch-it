package com.pitchIT.PitchUserService.models;

import com.pitchIT.PitchUserService.enums.UserRoles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class PitchBusinessUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String businessName;
    private String representativeFirstName;
    private String representativeLastName;
    private UserRoles businessRole;
    private String email;
    private String password;

    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     *
     * @return the authorities, sorted by natural key (never <code>null</code>)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.businessRole.name());
        System.out.println(authority);
        return Collections.singleton(authority);
    }



    /**
     * Returns the password used to authenticate the user.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return
     * <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Indicates whether the user's account has expired. An expired account cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user's account is valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked. A locked user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is not locked, <code>false</code> otherwise
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired. Expired
     * credentials prevent authentication.
     *
     * @return <code>true</code> if the user's credentials are valid (ie non-expired),
     * <code>false</code> if no longer valid (ie expired)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled. A disabled user cannot be
     * authenticated.
     *
     * @return <code>true</code> if the user is enabled, <code>false</code> otherwise
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public PitchBusinessUser(String businessName, String representativeFirstName, String representativeLastName, UserRoles businessRole, String email, String password) {
        this.businessName = businessName;
        this.representativeFirstName = representativeFirstName;
        this.representativeLastName = representativeLastName;
        this.businessRole = businessRole;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PitchBusinessUser{");
        sb.append("id=").append(id);
        sb.append(", businessName='").append(businessName).append('\'');
        sb.append(", representativeFirstName='").append(representativeFirstName).append('\'');
        sb.append(", representativeLastName='").append(representativeLastName).append('\'');
        sb.append(", businessRole=").append(businessRole);
        sb.append('}');
        return sb.toString();
    }

}