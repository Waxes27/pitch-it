package com.waxes27.PitchIt.Models.pitch;

import com.waxes27.PitchIt.Models.User.Business;
import com.waxes27.PitchIt.Models.pitch.submodels.TheBusiness;
import com.waxes27.PitchIt.Models.pitch.submodels.TheMarket;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pitch {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Transient
    private TheBusiness theBusiness;
    @Transient
    private TheMarket theMarket;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

}
