# Database Architecture Design

## Part 1: MySQL Relational Schema (Core Entities & Scheduling)

### Table: patients
- **id**: CHAR(36), Primary Key (UUID)
- **name**: VARCHAR(255), Not Null
- **email**: VARCHAR(255), Unique, Not Null *(Used for login)*
- **password_hash**: VARCHAR(255), Not Null
- **phone_number**: VARCHAR(20), Not Null
- **date_of_birth**: DATE, Not Null
- **gender**: TINYINT (0 = Male, 1 = Female, 2 = Other)
- **created_at**: DATETIME, Default CURRENT_TIMESTAMP
- **updated_at**: DATETIME, Default CURRENT_TIMESTAMP ON UPDATE


### Table: doctors
- **id**: CHAR(36), Primary Key (UUID)
- **name**: VARCHAR(255), Not Null
- **email**: VARCHAR(255), Unique, Not Null *(Used for login)*
- **password_hash**: VARCHAR(255), Not Null
- **phone_number**: VARCHAR(20), Not Null
- **specialty**: VARCHAR(100), Not Null
- **created_at**: DATETIME, Default CURRENT_TIMESTAMP
- **updated_at**: DATETIME, Default CURRENT_TIMESTAMP ON UPDATE


### Table: admins
- **id**: CHAR(36), Primary Key (UUID)
- **name**: VARCHAR(255), Not Null
- **email**: VARCHAR(255), Unique, Not Null *(Used for login)*
- **password_hash**: VARCHAR(255), Not Null
- **role**: TINYINT, Not Null (0 = Super Admin, 1 = Support Staff)
- **last_login**: DATETIME, Nullable
- **created_at**: DATETIME, Default CURRENT_TIMESTAMP
- **updated_at**: DATETIME, Default CURRENT_TIMESTAMP ON UPDATE

### Table: appointments
- **id**: INT, Primary Key, AUTO_INCREMENT
- **doctor_id**: CHAR(36), Foreign Key → doctors(id)
- **patient_id**: CHAR(36), Foreign Key → patients(id)
- **appointment_time**: DATETIME, Not Null
- **status**: TINYINT (0 = Scheduled, 1 = Completed, 2 = Cancelled)
- **version**: INT, Default 0 *(Used for optimistic locking to prevent double-booking)*
- **created_at**: DATETIME, Default CURRENT_TIMESTAMP
- **updated_at**: DATETIME, Default CURRENT_TIMESTAMP ON UPDATE

### Table: doctor_working_hours
- **id**: INT, Primary Key, AUTO_INCREMENT
- **doctor_id**: CHAR(36), Foreign Key → doctors(id)
- **day_of_week**: TINYINT (1 = Monday, 7 = Sunday)
- **start_time**: TIME, Not Null (e.g., 09:00:00)
- **end_time**: TIME, Not Null (e.g., 17:00:00)

### Table: doctor_time_off
- **id**: INT, Primary Key, AUTO_INCREMENT
- **doctor_id**: CHAR(36), Foreign Key → doctors(id)
- **start_datetime**: DATETIME, Not Null
- **end_datetime**: DATETIME, Not Null
- **reason**: VARCHAR(255), Nullable (e.g., "Vacation", "Conference")

---

## Part 2: MongoDB Document Schema (Clinical Data & Audit Trails)

### Collection: prescriptions
This collection stores patient prescriptions, utilizing embedded arrays to handle multiple medications per visit flexibly.
```json
{
  "_id": {
    "$oid": "60f7a9b8e4b0d3c1a2f4b9a1"
  },
  "patient_id": "550e8400-e29b-41d4-a716-446655440000",
  "doctor_id": "d9b2d63d-a233-4123-8472-928475619283",
  "appointment_id": 845,
  "date_issued": "2026-05-01T14:21:17Z",
  "diagnosis": "Acute Bacterial Sinusitis",
  "medications": [
    {
      "medication_name": "Amoxicillin",
      "dosage": "500mg",
      "route": "Oral",
      "frequency": "Every 8 hours",
      "duration_days": 10,
      "special_instructions": "Take with a full glass of water. Finish entire course."
    },
    {
      "medication_name": "Ibuprofen",
      "dosage": "400mg",
      "route": "Oral",
      "frequency": "Every 6 hours as needed",
      "duration_days": 5,
      "special_instructions": "Take with food to prevent stomach upset."
    }
  ],
  "doctor_notes": "Patient reported facial pain and congestion for 8 days. Follow up if no improvement in 48 hours.",
  "tags": [
    "Antibiotics",
    "Requires_Follow_Up"
  ],
  "metadata": {
    "created_at": "2026-05-01T14:21:17Z",
    "created_by_doctor_id": "d9b2d63d-a233-4123-8472-928475619283",
    "last_updated_at": "2026-05-01T14:21:17Z"
  }
}
```

### Collection: system_logs

This collection serves as an append-only audit trail, recording every critical create, update, or delete action taken within the platform to ensure security and compliance.
```json
{
  "_id": {
    "$oid": "71a8b9c0d4e1f2a3b4c5d6e7"
  },
  "timestamp": "2026-05-01T16:35:00Z",
  "event_type": "APPOINTMENT_CANCELLED",
  "actor": {
    "actor_id": "c8273918-b293-4817-9283-847561928374",
    "actor_role": "Admin",
    "actor_name": "Sarah Jenkins"
  },
  "entity": {
    "entity_type": "Appointment",
    "entity_id": 1042
  },
  "changes": {
    "before": {
      "status": 0,
      "appointment_time": "2026-05-10T14:00:00Z",
      "updated_at": "2026-04-28T09:15:00Z"
    },
    "after": {
      "status": 2,
      "appointment_time": "2026-05-10T14:00:00Z",
      "updated_at": "2026-05-01T16:35:00Z"
    }
  },
  "request_context": {
    "ip_address": "192.168.1.45",
    "user_agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36"
  }
}