package com.pitchIT.PitchUserService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InvestmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "pitch_investor_user_id", nullable = false, unique = true)
    private PitchInvestorUser pitchInvestorUser;

    @Transient
    private List<Map<String,String>> investments = new ArrayList<>();

    public InvestmentHistory(PitchInvestorUser pitchInvestorUser) {
        this.pitchInvestorUser = pitchInvestorUser;
    }

    public void addToInvestmentHistory(Map<String,String> investment){
        this.investments.add(investment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvestmentHistory that = (InvestmentHistory) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
