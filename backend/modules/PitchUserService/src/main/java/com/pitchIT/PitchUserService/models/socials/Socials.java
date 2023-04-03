package com.pitchIT.PitchUserService.models.socials;

import com.pitchIT.PitchUserService.models.CompanyDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Socials {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        private Long id;

        String website;
        String instagram;
        String twitter;
        String facebook;
        String linkedin;

        @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
        @JoinColumn(name = "company_details_id")
        private CompanyDetails companyDetails;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }
}