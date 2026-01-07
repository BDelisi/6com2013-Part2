import java.util.ArrayList;
import java.util.HashMap;

public class HealthcareModel {
    private HashMap<String, Facility> facilities;
    private HashMap<String, Clinician> clinicians;
    private HashMap<String, Patient> patients;
    private HashMap<String, Staff> staff;
    private HashMap<String, Appointment> appointments;
    private HashMap<String, Referral> referrals;
    private HashMap<String, Prescription> prescriptions;

    private static final String FACILITIES_FILE = "facilities.csv";
    private static final String CLINICIANS_FILE = "clinicians.csv";
    private static final String PATIENTS_FILE = "patients.csv";
    private static final String STAFF_FILE = "staff.csv";
    private static final String APPOINTMENTS_FILE = "appointments.csv";
    private static final String REFERRALS_FILE = "referrals.csv";
    private static final String PRESCRIPTIONS_FILE = "prescriptions.csv";

    public HealthcareModel() {
        facilities = new HashMap<String, Facility>();
        clinicians = new HashMap<String, Clinician>();
        patients = new HashMap<String, Patient>();
        staff = new HashMap<String, Staff>();
        appointments = new HashMap<String, Appointment>();
        referrals = new HashMap<String, Referral>();
        prescriptions = new HashMap<String, Prescription>();

        loadAllData();
    }

    public void loadAllData() {

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
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<Facility> facilitiesList = new ArrayList<Facility>(facilities.values());
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
}
