# Admin Stories

**Title:** *As an Admin, I want to log out of the platform, so that I can protect system access.*

* **Priority:** High
* **Story Points:** 1

**Acceptance Criteria:**
1. A logout action must be available that terminates the active session and redirects the user to the login page.
2. Users must not be able to navigate back to the secure dashboard without providing credentials again.

**Notes:**
* In case of a logout failure, the user must be notified with an appropriate error message.

---

**Title:** *As an Admin, I want to log in to the portal with my credentials, so that I can securely manage the platform.*

* **Priority:** High
* **Story Points:** 1

**Acceptance Criteria:**
1. The system must prompt the user for a registered username and password.
2. A login action must submit the credentials for validation.
3. Upon successful validation, the admin is redirected to the Admin Dashboard.

**Notes:**
* Users must have an existing registered account to log in.
* In case of incorrect credentials or system failure, the user must be notified.

---

**Title:** *As an Admin, I want to add doctors to the portal, so that they are available for patient appointments.*

* **Priority:** High
* **Story Points:** 2

**Acceptance Criteria:**
1. The system must provide a form to capture necessary doctor information (e.g., name, specialty, contact info).
2. All input fields must be validated before submission.
3. A submit action must save the new doctor to the database.
4. Once added, the new doctor must immediately be visible on the patient-facing dashboards and search lists.

**Notes:**
* In case of a processing failure, the admin must be informed with a specific error message.

---

**Title:** *As an Admin, I want to delete doctors from the platform, to show that they are no longer available.*

* **Priority:** High
* **Story Points:** 2

**Acceptance Criteria:**
1. A delete action must be available for each doctor listed in the admin view.
2. The system must prompt the admin with a confirmation dialog ("Are you sure?") before executing the deletion.
3. Upon successful deletion, the doctor's information must be completely removed from both the Admin and Patient dashboards.
4. The deleted doctor must immediately lose access to the Doctor Dashboard.

**Notes:**
* In case of a processing failure, the admin must be informed.

---

**Title:** *As an Admin, I want to track the number of appointments each month and see statistics, to monitor platform usage.*

* **Priority:** Medium
* **Story Points:** 2

**Acceptance Criteria:**
1. The dashboard must display metric cards showing aggregated appointment statistics.
2. A visual chart must be included that maps the count of appointments against each month.

**Notes:**
* If a specific analytic fails to load, that section should gracefully display a "Data not available" message without crashing the page.


# Patient Stories

**Title:** *As a Patient, I want to see a list of doctors without logging in, so that I can explore my options before registering.*

* **Priority:** Medium/Low
* **Story Points:** 1

**Acceptance Criteria:**
1. The public-facing main page must display a list of active doctors.
2. The list must include the doctor's specialty and general booking information.

---

**Title:** *As a Patient, I want to register for a new account, so that I can manage my medical bookings.*

* **Priority:** High
* **Story Points:** 1

**Acceptance Criteria:**
1. The system must prompt the user for registration details, including a username and password.
2. Credentials and inputs must be validated before creating the account.
3. A "Register" action must create the account and redirect the patient to the platform.
4. An "Already have an account?" link must be available to redirect existing users to the login page.

**Notes:**
* In case of a validation or processing failure, the user must be notified.

---

**Title:** *As a Patient, I want to log in with my credentials, so that I can access and manage my bookings.*

* **Priority:** High
* **Story Points:** 1

**Acceptance Criteria:**
1. The system must prompt the user for their registered username and password.
2. A login action must validate the credentials and redirect the patient to their dashboard.
3. A "Don't have an account?" link must be available to redirect new users to the registration page.

**Notes:**
* In case of incorrect credentials or a processing failure, the user must be notified.

---

**Title:** *As a Patient, I want to log out, so that I can protect access to my personal dashboard.*

* **Priority:** High
* **Story Points:** 1

**Acceptance Criteria:**
1. A logout action must terminate the active session and redirect the user to the login page.
2. Users must not be able to navigate back to the secure dashboard without providing credentials again.

**Notes:**
* In case of a logout failure, the user must be notified with a message.

---

**Title:** *As a Patient, I want to book a one-hour appointment with a specific doctor, so that I can secure a medical consultation.*

* **Priority:** High
* **Story Points:** 4

**Acceptance Criteria:**
1. A search interface must allow the user to find and select a specific doctor by name or specialty.
2. The interface must display the selected doctor's available dates.
3. The user must be able to select an available time slot within a specific date.
4. A submit action must confirm the booking.
5. The system must prompt the patient to confirm their booking details before finalizing.

**Notes:**
* In case of a request processing failure, users must be notified with a message.

---

**Title:** *As a Patient, I want to see my upcoming appointments, to keep track of my bookings.*

* **Priority:** Medium
* **Story Points:** 1

**Acceptance Criteria:**
1. A list must be displayed showing appointment details: doctor's name, doctor's specialty, booked date, and booked time.

**Notes:**
* In case of no appointments or a backend failure, a proper message should be shown to the user.


# Doctor Stories

**Title:** *As a Doctor, I need to log in to my account, so that I can manage my appointments.*

* **Priority:** High
* **Story Points:** 1

**Acceptance Criteria:**
1. The system must prompt the user for a username and password.
2. A login action must validate the credentials before granting access to the platform.
3. A "Don't have an account?" link must be available to redirect users to the registration page.

**Notes:**
* In case of a login failure, users must be notified with a message.

---

**Title:** *As a Doctor, I need to log out from my account, so that I can protect my data.*

* **Priority:** Medium
* **Story Points:** 1

**Acceptance Criteria:**
1. A logout action must terminate the active session and redirect users to the login page.
2. Users must not be able to navigate back to the dashboard without providing credentials again.

**Notes:**
* In case of a logout failure, users must be notified with a message.

---

**Title:** *As a Doctor, I need to view my appointments, to keep track of my schedule.*

* **Priority:** High
* **Story Points:** 4

**Acceptance Criteria:**
1. The dashboard must display a list of upcoming appointments along with the patient's information details.

**Notes:**
* In case of no appointments or a backend failure, a proper message should be shown to the user.

---

**Title:** *As a Doctor, I need to mark my unavailability, to inform patients and prevent double-booking.*

* **Priority:** High
* **Story Points:** 4

**Acceptance Criteria:**
1. The user must be able to select or unselect specific days to mark as unavailable.
2. The interface must clearly indicate which days are currently selected.
3. The user must be able to submit the newly selected days.
4. Patient-facing scheduling interfaces must immediately reflect this unavailability to prevent new bookings on those dates.

**Notes:**
* In case of a processing request failure, the user must be informed with a proper message.

---

**Title:** *As a Doctor, I need to update my contact information, so that patients have up-to-date information.*

* **Priority:** High
* **Story Points:** 4

**Acceptance Criteria:**
1. A form must be available to edit fields such as email, phone number, specialty, and profile picture.
2. Input data on each field must be validated.
3. The user must be able to submit the updated information.
4. The updated information must immediately reflect on the Patient dashboard and the public main website.

**Notes:**
* In case of a processing request failure, the user must be informed with a proper message.
