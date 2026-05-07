package com.project.back_end.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctors")
@Getter // Auto-generates all getters
@Setter // Auto-generates all setters
@NoArgsConstructor // Auto-generates the empty constructor for JPA/Jackson
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)", updatable = false, nullable = false)
    private String id;

    @NotNull
    @Size(min = 2, max = 255)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @NotNull
    @Size(max = 20)
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false)
    private String specialty;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
