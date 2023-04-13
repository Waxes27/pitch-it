package com.pitchIT.PitchService.models.socials;

import com.pitchIT.PitchService.models.CompanyDetails;
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

        @Override
        public String toString() {
                final StringBuffer sb = new StringBuffer("{");
                sb.append("id:").append(id);
                sb.append(", website:'").append(website).append('\'');
                sb.append(", instagram:'").append(instagram).append('\'');
                sb.append(", twitter:'").append(twitter).append('\'');
                sb.append(", facebook:'").append(facebook).append('\'');
                sb.append(", linkedin:'").append(linkedin).append('\'');
//                sb.append(", companyDetails:").append(companyDetails);
                sb.append('}');
                return sb.toString();
        }
}