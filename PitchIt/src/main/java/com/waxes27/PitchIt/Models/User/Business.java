package com.waxes27.PitchIt.Models.User;

import com.waxes27.PitchIt.Models.IUser;
import com.waxes27.PitchIt.Models.User.enums.business.GrowthStage;
import com.waxes27.PitchIt.Models.User.enums.business.Sector;
import com.waxes27.PitchIt.Models.pitch.Pitch;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Business implements IUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String companyName;
    private String registrationNumber;
    private String website;
    private String facebook;
    private String instagram;
    private String linkedIn;
    private String twitter;
    private Sector sector;
    private GrowthStage growthStage;

    @OneToMany(mappedBy = "business", orphanRemoval = true)
    private Set<Pitch> pitches = new LinkedHashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
