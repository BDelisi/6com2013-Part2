public class Prescription {
    public String id;
    public String patientId;
    public String clinicId;
    public String appointmentId;
    public String prescriptionDate;
    public String medicationName;
    public String dosage;
    public String frequency;
    public int durationDays;
    public String quantity;
    public String instructions;
    public String pharmacyName;
    public String status;
    public String issueDate;
    public String collection;

    public Prescription(String id, String patientId, String clinicId, String appointmentId, String prescriptionDate, String medicationName, String dosage, String frequency, int durationDays,  String quantity, String instructions, String pharmacyName, String status, String issueDate, String collection) {
        this.id = id;
        this.patientId = patientId;
        this.clinicId = clinicId;
        this.appointmentId = appointmentId;
        this.prescriptionDate = prescriptionDate;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.frequency = frequency;
        this.durationDays = durationDays;
        this.quantity = quantity;
        this.instructions = instructions;
        this.pharmacyName = pharmacyName;
        this.status = status;
        this.issueDate = issueDate;
        this.collection = collection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public static Prescription fromCSV(String csv) {
        String[] parts = csv.split(",");
        String tempCollection;
        if (parts.length != 15) {
            tempCollection = "";
        } else {
            tempCollection = parts[14];
        }
        return new Prescription(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], Integer.parseInt(parts[8]), parts[9], parts[10], parts[11], parts[12], parts[13], tempCollection);
    }

    @Override
    public String toString() {
        return id + "," + patientId + "," + clinicId + "," + appointmentId + "," + prescriptionDate + "," + medicationName + "," + dosage + "," + frequency  + "," + durationDays  + "," + quantity  + "," + instructions + "," + pharmacyName + "," + status + "," + issueDate + "," + collection;
    }
}
