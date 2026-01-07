public class Appointment {
    private String id;
    private String patientId;
    private String clinicianId;
    private String facultyId;
    private String appointmentDate;
    private String appointmentTime;
    private int durationMinutes;
    private String appointmentType;
    private String status;
    private String reasonForVisit;
    private String createdDate;
    private String lastModified;

    public Appointment(String appointmentId, String patientId, String clinicianId, String facultyId, String appointmentDate, String appointmentTime, int durationMinutes, String appointmentType, String status, String reasonForVisit, String createdDate, String lastModified) {
        this.id = appointmentId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.facultyId = facultyId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.durationMinutes = durationMinutes;
        this.appointmentType = appointmentType;
        this.status = status;
        this.reasonForVisit = reasonForVisit;
        this.createdDate = createdDate;
        this.lastModified = lastModified;
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

    public String getClinicianId() {
        return clinicianId;
    }

    public void setClinicianId(String clinicianId) {
        this.clinicianId = clinicianId;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public static Appointment fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Appointment(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], Integer.parseInt(parts[6]), parts[7], parts[8], parts[9], parts[10], parts[11]);
    }

    @Override
    public String toString() {
        return id + "," + patientId + "," + clinicianId + "," + facultyId + "," + appointmentDate + "," + appointmentTime + "," + durationMinutes + "," + appointmentType + "," + status + "," + reasonForVisit + "," + createdDate + "," + lastModified;
    }


}
