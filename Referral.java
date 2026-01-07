public class Referral {
    public  String id;
    public  String patientId;
    public String referringClinicianId;
    public String referredToClinicianId;
    public String referringFacilityId;
    public String referredToFacilityId;
    public String referralDate;
    public String urgencyLevel;
    public String referralReason;
    public String clinicianSummary;
    public String requestedInvestigations;
    public String status;
    public String appointmentId;
    public String notes;
    public String createdDate;
    public String lastUpdated;

    public Referral(String id, String patientId, String referringClinicianId, String referredToClinicianId, String referringFacilityId, String referredToFacilityId, String referralDate, String urgencyLevel, String referralReason, String clinicianSummary, String requestedInvestigations, String status, String appointmentId, String notes, String createdDate, String lastUpdated) {
        this.id = id;
        this.patientId = patientId;
        this.referringClinicianId = referringClinicianId;
        this.referredToClinicianId = referredToClinicianId;
        this.referringFacilityId = referringFacilityId;
        this.referredToFacilityId = referredToFacilityId;
        this.referralDate = referralDate;
        this.urgencyLevel = urgencyLevel;
        this.referralReason = referralReason;
        this.clinicianSummary = clinicianSummary;
        this.requestedInvestigations = requestedInvestigations;
        this.status = status;
        this.appointmentId = appointmentId;
        this.notes = notes;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
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

    public String getReferringClinicianId() {
        return referringClinicianId;
    }

    public void setReferringClinicianId(String referringClinicianId) {
        this.referringClinicianId = referringClinicianId;
    }

    public String getReferredToClinicianId() {
        return referredToClinicianId;
    }

    public void setReferredToClinicianId(String referredToClinicianId) {
        this.referredToClinicianId = referredToClinicianId;
    }

    public String getReferringFacilityId() {
        return referringFacilityId;
    }

    public void setReferringFacilityId(String referringFacilityId) {
        this.referringFacilityId = referringFacilityId;
    }

    public String getReferredToFacilityId() {
        return referredToFacilityId;
    }

    public void setReferredToFacilityId(String referredToFacilityId) {
        this.referredToFacilityId = referredToFacilityId;
    }

    public String getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(String referralDate) {
        this.referralDate = referralDate;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getReferralReason() {
        return referralReason;
    }

    public void setReferralReason(String referralReason) {
        this.referralReason = referralReason;
    }

    public String getClinicianSummary() {
        return clinicianSummary;
    }

    public void setClinicianSummary(String clinicianSummary) {
        this.clinicianSummary = clinicianSummary;
    }

    public String getRequestedInvestigations() {
        return requestedInvestigations;
    }

    public void setRequestedInvestigations(String requestedInvestigations) {
        this.requestedInvestigations = requestedInvestigations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public static Referral fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Referral(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9], parts[10], parts[11], parts[12], parts[13], parts[14], parts[15]);
    }

    @Override
    public String toString() {
        return id + "," + patientId + "," + referringClinicianId  + "," + referredToClinicianId + "," + referringFacilityId + "," +  referredToFacilityId + "," + referralDate + "," + urgencyLevel + "," + referralReason + "," + clinicianSummary + "," + requestedInvestigations + "," + status + "," + appointmentId + "," + notes + "," + createdDate + "," + lastUpdated;
    }
}
