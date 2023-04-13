package com.pitchIT.PitchService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BusinessDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pitch_id")
    @JsonIgnore
    private Pitch pitch;

    private String product;
    private String problemSolved;
    private String businessModel;
    private String reasonForRaising;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("{");
        sb.append("id:").append(id);
//        sb.append(", pitch:").append(pitch);
        sb.append(", product:'").append(product).append('\'');
        sb.append(", problemSolved:'").append(problemSolved).append('\'');
        sb.append(", businessModel:'").append(businessModel).append('\'');
        sb.append(", reasonForRaising:'").append(reasonForRaising).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
