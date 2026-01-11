import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HealthcareModel {
    private HashMap<String, Facility> facilities;
    private HashMap<String, Clinician> clinicians;
    private HashMap<String, Patient> patients;
    private HashMap<String, Staff> staffMap;
    private HashMap<String, Appointment> appointments;
    private HashMap<String, Referral> referrals;
    private HashMap<String, Prescription> prescriptions;

    private static final String FACILITIES_FILE = "src/facilities.csv";
    private static final String CLINICIANS_FILE = "src/clinicians.csv";
    private static final String PATIENTS_FILE = "src/patients.csv";
    private static final String STAFF_FILE = "src/staff.csv";
    private static final String APPOINTMENTS_FILE = "src/appointments.csv";
    private static final String REFERRALS_FILE = "src/referrals.csv";
    private static final String PRESCRIPTIONS_FILE = "src/prescriptions.csv";

    public HealthcareModel() {
        facilities = new HashMap<String, Facility>();
        clinicians = new HashMap<String, Clinician>();
        patients = new HashMap<String, Patient>();
        staffMap = new HashMap<String, Staff>();
        appointments = new HashMap<String, Appointment>();
        referrals = new HashMap<String, Referral>();
        prescriptions = new HashMap<String, Prescription>();

        loadAllData();
    }

    public void loadAllData() {
        loadFacilities();
        loadClinicians();
        loadPatients();
        loadStaff();
        loadAppointments();
        loadReferrals();
        loadPrescriptions();
    }

    public void saveAllData() {
        saveFacilities();
        saveClinicians();
        savePatients();
        saveStaff();
        saveAppointments();
        saveReferrals();
        savePrescriptions();
    }

    //=============== Facilities Management ============================
    private void loadFacilities() {
        ArrayList<String> lines = CSVHandler.readLines(FACILITIES_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Facility facility = Facility.fromCSV(lines.get(i));
            facilities.put(facility.getId(), facility);
        }
    }

    public void saveFacilities() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Facility> facilitiesList = new ArrayList<>(facilities.values());
        lines.add("facility_id,facility_name,facility_type,address,postcode,phone_number,email,opening_hours,manager_name,capacity,specialities_offered");
        for (int i = 0; i < facilitiesList.size(); i++) {
            lines.add(facilitiesList.get(i).toString());
        }
        CSVHandler.writeLines(FACILITIES_FILE, lines);
    }

    public void addFacility(Facility facility) {
        facilities.put(facility.getId(), facility);
        saveFacilities();
    }

    public ArrayList<Facility> getAllFacilities() {
        return new ArrayList<Facility>(facilities.values());
    }

    public Facility getFacilityById(String id) {
        return facilities.get(id);
    }

    public String generateFacilityId() {
        Set<Integer> usedNumbers = new HashSet<>();
        for (String id : facilities.keySet()) {
            int number = Integer.parseInt(id.substring(1));
            usedNumbers.add(number);
        }

        int newIdNumber = 1;
        while (usedNumbers.contains(newIdNumber)) {
            newIdNumber++;
        }

        return String.format("H%03d", newIdNumber);
    }


    //=============== Clinician Management ============================
    private void loadClinicians() {
        ArrayList<String> lines = CSVHandler.readLines(CLINICIANS_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Clinician clinician = Clinician.fromCSV(lines.get(i));
            clinicians.put(clinician.getId(), clinician);
        }
    }

    public void saveClinicians() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Clinician> cliniciansList = new ArrayList<>(clinicians.values());
        lines.add("clinician_id,first_name,last_name,title,speciality,gmc_number,phone_number,email,workplace_id,workplace_type,employment_status,start_date");
        for (int i = 0; i < cliniciansList.size(); i++) {
            lines.add(cliniciansList.get(i).toString());
        }
        CSVHandler.writeLines(CLINICIANS_FILE, lines);
    }

    public void addClinician(Clinician clinician) {
        clinicians.put(clinician.getId(), clinician);
        saveClinicians();
    }

    public ArrayList<Clinician> getAllClinicians() {
        return new ArrayList<Clinician>(clinicians.values());
    }

    public Clinician getClinicianById(String id) {
        return clinicians.get(id);
    }

    public String generateClinicianId() {
        Set<Integer> usedNumbers = new HashSet<>();
        for (String id : clinicians.keySet()) {
            int number = Integer.parseInt(id.substring(1));
            usedNumbers.add(number);
        }

        int newIdNumber = 1;
        while (usedNumbers.contains(newIdNumber)) {
            newIdNumber++;
        }

        return String.format("C%03d", newIdNumber);
    }


    //=============== Patient Management ============================
    private void loadPatients() {
        ArrayList<String> lines = CSVHandler.readLines(PATIENTS_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Patient patient = Patient.fromCSV(lines.get(i));
            patients.put(patient.getId(), patient);
        }
    }

    public void savePatients() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Patient> patientsList = new ArrayList<>(patients.values());
        lines.add("patient_id,first_name,last_name,date_of_birth,nhs_number,gender,phone_number,email,address,postcode,emergency_contact_name,emergency_contact_phone,registration_date,gp_surgery_id");
        for (int i = 0; i < patientsList.size(); i++) {
            lines.add(patientsList.get(i).toString());
        }
        CSVHandler.writeLines(PATIENTS_FILE, lines);
    }

    public void addPatient(Patient patient) {
        patients.put(patient.getId(), patient);
        savePatients();
    }

    public ArrayList<Patient> getAllPatients() {
        return new ArrayList<Patient>(patients.values());
    }

    public Patient getPatientById(String id) {
        return patients.get(id);
    }

    public String generatePatientId() {
        Set<Integer> usedNumbers = new HashSet<>();
        for (String id : patients.keySet()) {
            int number = Integer.parseInt(id.substring(1));
            usedNumbers.add(number);
        }

        int newIdNumber = 1;
        while (usedNumbers.contains(newIdNumber)) {
            newIdNumber++;
        }

        return String.format("P%03d", newIdNumber);
    }


    //=============== Staff Management ============================
    private void loadStaff() {
        ArrayList<String> lines = CSVHandler.readLines(STAFF_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Staff staff = Staff.fromCSV(lines.get(i));
            staffMap.put(staff.getId(), staff);
        }
    }

    public void saveStaff() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>(staffMap.values());
        lines.add("staff_id,first_name,last_name,role,department,facility_id,phone_number,email,employment_status,start_date,line_manager,access_level");
        for (int i = 0; i < staffList.size(); i++) {
            lines.add(staffList.get(i).toString());
        }
        CSVHandler.writeLines(STAFF_FILE, lines);
    }

    public void addStaff(Staff staff) {
        staffMap.put(staff.getId(), staff);
        saveStaff();
    }

    public ArrayList<Staff> getAllStaff() {
        return new ArrayList<Staff>(staffMap.values());
    }

    public Staff getStaffById(String id) {
        return staffMap.get(id);
    }

    public String generateStaffId() {
        Set<Integer> usedNumbers = new HashSet<>();
        for (String id : staffMap.keySet()) {
            int number = Integer.parseInt(id.substring(2));
            usedNumbers.add(number);
        }

        int newIdNumber = 1;
        while (usedNumbers.contains(newIdNumber)) {
            newIdNumber++;
        }

        return String.format("ST%03d", newIdNumber);
    }


    //=============== Appointment Management ============================
    private void loadAppointments() {
        ArrayList<String> lines = CSVHandler.readLines(APPOINTMENTS_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Appointment staff = Appointment.fromCSV(lines.get(i));
            appointments.put(staff.getId(), staff);
        }
    }

    public void saveAppointments() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Appointment> appointmentList = new ArrayList<>(appointments.values());
        lines.add("appointment_id,patient_id,clinician_id,facility_id,appointment_date,appointment_time,duration_minutes,appointment_type,status,reason_for_visit,notes,created_date,last_modified");
        for (int i = 0; i < appointmentList.size(); i++) {
            lines.add(appointmentList.get(i).toString());
        }
        CSVHandler.writeLines(APPOINTMENTS_FILE, lines);
    }

    public void addAppointment(Appointment appointment) {
        appointments.put(appointment.getId(), appointment);
        saveAppointments();
    }

    public ArrayList<Appointment> getAllAppointments() {
        return new ArrayList<Appointment>(appointments.values());
    }

    public Appointment getAppointmentById(String id) {
        return appointments.get(id);
    }

    public String generateAppointmentId() {
        Set<Integer> usedNumbers = new HashSet<>();
        for (String id : appointments.keySet()) {
            int number = Integer.parseInt(id.substring(1));
            usedNumbers.add(number);
        }

        int newIdNumber = 1;
        while (usedNumbers.contains(newIdNumber)) {
            newIdNumber++;
        }

        return String.format("A%03d", newIdNumber);
    }


    //=============== Referral Management ============================
    private void loadReferrals() {
        ArrayList<String> lines = CSVHandler.readLines(REFERRALS_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Referral referral = Referral.fromCSV(lines.get(i));
            referrals.put(referral.getId(), referral);
        }
    }

    public void saveReferrals() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Referral> referralList = new ArrayList<>(referrals.values());
        lines.add("referral_id,patient_id,referring_clinician_id,referred_to_clinician_id,referring_facility_id,referred_to_facility_id,referral_date,urgency_level,referral_reason,clinical_summary,requested_investigations,status,appointment_id,notes,created_date,last_updated");
        for (int i = 0; i < referralList.size(); i++) {
            lines.add(referralList.get(i).toString());
        }
        CSVHandler.writeLines(REFERRALS_FILE, lines);
    }

    public void addReferral(Referral referral) {
        referrals.put(referral.getId(), referral);
        saveReferrals();
    }

    public ArrayList<Referral> getAllReferrals() {
        return new ArrayList<Referral>(referrals.values());
    }

    public Referral getReferralById(String id) {
        return referrals.get(id);
    }

    public String generateReferralId() {
        return "S" + referrals.size();
    }


    //=============== Prescription Management ============================
    private void loadPrescriptions() {
        ArrayList<String> lines = CSVHandler.readLines(PRESCRIPTIONS_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Prescription prescription = Prescription.fromCSV(lines.get(i));
            prescriptions.put(prescription.getId(), prescription);
        }
    }

    public void savePrescriptions() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Prescription> prescriptionList = new ArrayList<>(prescriptions.values());
        lines.add("prescription_id,patient_id,clinician_id,appointment_id,prescription_date,medication_name,dosage,frequency,duration_days,quantity,instructions,pharmacy_name,status,issue_date,collection_date");
        for (int i = 0; i < prescriptionList.size(); i++) {
            lines.add(prescriptionList.get(i).toString());
        }
        CSVHandler.writeLines(PRESCRIPTIONS_FILE, lines);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.put(prescription.getId(), prescription);
        savePrescriptions();
    }

    public ArrayList<Prescription> getAllPrescriptions() {
        return new ArrayList<Prescription>(prescriptions.values());
    }

    public Prescription getPrescriptionById(String id) {
        return prescriptions.get(id);
    }

    public String generatePrescriptionId() {
        Set<Integer> usedNumbers = new HashSet<>();
        for (String id : prescriptions.keySet()) {
            int number = Integer.parseInt(id.substring(1));
            usedNumbers.add(number);
        }

        int newIdNumber = 1;
        while (usedNumbers.contains(newIdNumber)) {
            newIdNumber++;
        }

        return String.format("RX%03d", newIdNumber);
    }
}