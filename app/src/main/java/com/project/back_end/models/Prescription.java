package com.project.back_end.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;
import java.util.List;

@Document(collection = "prescriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {

    @Id
    private String id;

    @NotNull
    @Field("patient_id")
    private String patientId;

    @NotNull
    @Field("doctor_id")
    private String doctorId;

    @NotNull
    @Field("appointment_id")
    private Integer appointmentId;

    @Field("date_issued")
    private Instant dateIssued;

    @NotNull
    @Size(min = 2)
    private String diagnosis;

    private List<Medication> medications;

    @Field("doctor_notes")
    private String doctorNotes;

    private List<String> tags;

    private PrescriptionMetadata metadata;

    // --- Nested Classes ---

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Medication {
        @NotNull
        @Field("medication_name")
        private String medicationName;
        
        @NotNull
        private String dosage;
        
        @NotNull
        private String route;
        
        @NotNull
        private String frequency;
        
        @NotNull
        @Field("duration_days")
        private Integer durationDays;
        
        @Field("special_instructions")
        private String specialInstructions;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class PrescriptionMetadata {
        @Field("created_at")
        private Instant createdAt;
        
        @Field("created_by_doctor_id")
        private String createdByDoctorId;
        
        @Field("last_updated_at")
        private Instant lastUpdatedAt;
    }
}