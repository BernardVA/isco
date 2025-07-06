package com.ibm.be.isco.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "control_strength")
@Data
public class ControlStrength {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "control_strength_id")
    private Long controlStrengthId;

    @Column(name = "score")
    private Float score;

    @Column(name = "calculated_at")
    private LocalDateTime calculatedAt;


}