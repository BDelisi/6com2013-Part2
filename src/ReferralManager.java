import java.time.LocalDate;
import java.util.ArrayList;

public class ReferralManager {
    private static ReferralManager instance;

    private HealthcareModel model;

    private ReferralManager(HealthcareModel model) {
        this.model = model;
    }

    public static ReferralManager getInstance(HealthcareModel model) {
        if (instance == null) {
            instance = new ReferralManager(model);
        }
        return instance;
    }

    public Referral createReferral(String patientId, String referringClinicianId, String referredToClinicianId, String referringFacilityId,
                                   String referredToFacilityId, String urgency, String reason, String summary) {
        String id = model.generateReferralId();
        String today = model.getDate();

        Referral referral = new Referral(id, patientId, referringClinicianId, referredToClinicianId, referringFacilityId, referredToFacilityId,
                today, urgency, reason, summary, "", "New", "", "", today, today);

        model.addReferral(referral);
        return referral;
    }

    public void updateReferralStatus(String referralId, String newStatus) {
        Referral referral = model.getReferralById(referralId);
        if (referral == null) return;

        referral.setStatus(newStatus);
        referral.setLastUpdated(model.getDate());
        model.saveReferrals();
    }

    public String generateReferralEmail(Referral r) {
        return """ 
                To: Specialist Department
                Subject: New Referral %s

                Patient ID: %s
                Referring Clinician: %s
                Referred To: %s
                Urgency: %s

                Clinical Summary:
                %s

                Requested Investigations:
                %s

                Created: %s
                """.formatted(
                r.getId(),
                r.getPatientId(),
                r.getReferringClinicianId(),
                r.getReferredToClinicianId(),
                r.getUrgencyLevel(),
                r.getClinicianSummary(),
                r.getRequestedInvestigations(),
                r.getCreatedDate()
        );
    }
}
