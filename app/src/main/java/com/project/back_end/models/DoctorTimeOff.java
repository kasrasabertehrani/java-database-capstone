package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@Entity
@Table(name = "doctor_time_off")
@Getter // Auto-generates all getters
@Setter // Auto-generates all setters
@NoArgsConstructor // Auto-generates the empty constructor for JPA/Jackson
public class DoctorTimeOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @NotNull
    @Column(name = "start_datetime", nullable = false)
    private LocalDateTime startDatetime;

    @NotNull
    @Column(name = "end_datetime", nullable = false)
    private LocalDateTime endDatetime;

    @Size(max = 255)
    @Column(name = "reason")
    private String reason;


}
