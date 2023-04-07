package com.pitchIT.PitchUserService.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InvestmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "pitch_investor_user_id", nullable = false, unique = true)
    private PitchInvestorUser pitchInvestorUser;

    @OneToMany(mappedBy = "investmentHistory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Investments> investments = new ArrayList<>();

}
