import java.util.ArrayList;
import java.util.HashMap;

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

    private void saveFacilities() {
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
        return "S" + facilities.size();
    }


    //=============== Clinician Management ============================
    private void loadClinicians() {
        ArrayList<String> lines = CSVHandler.readLines(CLINICIANS_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Clinician clinician = Clinician.fromCSV(lines.get(i));
            clinicians.put(clinician.getId(), clinician);
        }
    }

    private void saveClinicians() {
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
        return "S" + clinicians.size();
    }


    //=============== Patient Management ============================
    private void loadPatients() {
        ArrayList<String> lines = CSVHandler.readLines(PATIENTS_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Patient patient = Patient.fromCSV(lines.get(i));
            patients.put(patient.getId(), patient);
        }
    }

    private void savePatients() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Patient> patientsList = new ArrayList<>(patients.values());
        lines.add("clinician_id,first_name,last_name,title,speciality,gmc_number,phone_number,email,workplace_id,workplace_type,employment_status,start_date");
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
        return "S" + patients.size();
    }


    //=============== Staff Management ============================
    private void loadStaff() {
        ArrayList<String> lines = CSVHandler.readLines(STAFF_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Staff staff = Staff.fromCSV(lines.get(i));
            staffMap.put(staff.getId(), staff);
        }
    }

    private void saveStaff() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>(staffMap.values());
        lines.add("clinician_id,first_name,last_name,title,speciality,gmc_number,phone_number,email,workplace_id,workplace_type,employment_status,start_date");
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
        return "S" + staffMap.size();
    }


    //=============== Appointment Management ============================
    private void loadAppointments() {
        ArrayList<String> lines = CSVHandler.readLines(APPOINTMENTS_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Appointment staff = Appointment.fromCSV(lines.get(i));
            appointments.put(staff.getId(), staff);
        }
    }

    private void saveAppointments() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Appointment> appointmentList = new ArrayList<>(appointments.values());
        lines.add("clinician_id,first_name,last_name,title,speciality,gmc_number,phone_number,email,workplace_id,workplace_type,employment_status,start_date");
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
        return "S" + appointments.size();
    }


    //=============== Referral Management ============================
    private void loadReferrals() {
        ArrayList<String> lines = CSVHandler.readLines(REFERRALS_FILE);
        for (int i = 1; i < lines.size(); i++) {
            Referral referral = Referral.fromCSV(lines.get(i));
            referrals.put(referral.getId(), referral);
        }
    }

    private void saveReferrals() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Referral> referralList = new ArrayList<>(referrals.values());
        lines.add("clinician_id,first_name,last_name,title,speciality,gmc_number,phone_number,email,workplace_id,workplace_type,employment_status,start_date");
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

    private void savePrescriptions() {
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Prescription> prescriptionList = new ArrayList<>(prescriptions.values());
        lines.add("clinician_id,first_name,last_name,title,speciality,gmc_number,phone_number,email,workplace_id,workplace_type,employment_status,start_date");
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
        return "S" + prescriptions.size();
    }
}