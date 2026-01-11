import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HealthcareView extends JFrame {

    private HealthcareModel model;

    private JTabbedPane tabbedPane;

    public HealthcareView(HealthcareModel model) {
        this.model = model;

        setTitle("Healthcare Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Facility", createFacilitiesPanel());
        tabbedPane.addTab("Clinicians", createCliniciansPanel());
        tabbedPane.addTab("Patients", createPatientsPanel());
        tabbedPane.addTab("Staff", createStaffPanel());
        tabbedPane.addTab("Appointments", createAppointmentsPanel());
        tabbedPane.addTab("Prescriptions", createPrescriptionsPanel());
        tabbedPane.addTab("Referrals", createReferralsPanel());

        add(tabbedPane);
    }
    // ================= Facilities ===============
    private JPanel createFacilitiesPanel() {
        JPanel panel = new JPanel(new BorderLayout());


        String[] columns = {"facility_id","facility_name","facility_type","address","postcode","phone_number","email","opening_hours","manager_name","capacity","specialities_offered"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Facility f : model.getAllFacilities()) {
            tableModel.addRow(new Object[]{
                    f.getId(),
                    f.getFacilityName(),
                    f.getFacilityType(),
                    f.getAddress(),
                    f.getPostCode(),
                    f.getPhoneNumber(),
                    f.getEmail(),
                    f.getOpeningHours(),
                    f.getManagerName(),
                    f.getCapacity(),
                    f.getSpecialtiesOffered()
            });
        }
        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Facility"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Clinicians =================
    private JPanel createCliniciansPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"clinician_id","first_name","last_name","title","speciality","gmc_number","phone_number","email","workplace_id","workplace_type","employment_status","start_date"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Clinician c : model.getAllClinicians()) {
            tableModel.addRow(new Object[]{
                    c.getId(),
                    c.getFirstName(),
                    c.getLastName(),
                    c.getTitle(),
                    c.getSpecialty(),
                    c.getGmcNumber(),
                    c.getPhoneNumber(),
                    c.getEmail(),
                    c.getWorkPlaceId(),
                    c.getWorkPlaceType(),
                    c.getEmploymentStatus(),
                    c.getStartDate()
            });
        }

        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Clinician"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Patients =================
    private JPanel createPatientsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"patient_id","first_name","last_name","date_of_birth","nhs_number","gender","phone_number","email","address","postcode","emergency_contact_name","emergency_contact_phone","registration_date","gp_surgery_id"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Patient p : model.getAllPatients()) {
            tableModel.addRow(new Object[]{
                    p.getId(),
                    p.getFirstName(),
                    p.getLastName(),
                    p.getDateOfBirth(),
                    p.getNhsNumber(),
                    p.getGender(),
                    p.getPhoneNumber(),
                    p.getEmail(),
                    p.getAddress(),
                    p.getPostCode(),
                    p.getEmergencyContactName(),
                    p.getEmergencyContactPhone(),
                    p.getRegistrationDate(),
                    p.getGpSurgeryId()
            });
        }

        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Patient"), BorderLayout.SOUTH);
        return panel;
    }

    // =================== Staff ======================
    private JPanel createStaffPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"staff_id","first_name","last_name","role","department","facility_id","phone_number","email","employment_status","start_date","line_manager","access_level"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Staff s : model.getAllStaff()) {
            tableModel.addRow(new Object[]{
                    s.getId(),
                    s.getFirstName(),
                    s.getLastName(),
                    s.getRole(),
                    s.getDepartment(),
                    s.getFacilityId(),
                    s.getPhoneNumber(),
                    s.getEmail(),
                    s.getEmploymentStatus(),
                    s.getStartDate(),
                    s.getLineManager(),
                    s.getAccessLevel()
            });
        }

        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Staff"), BorderLayout.SOUTH);
        return panel;
    }


    // ================= Appointments =================
    private JPanel createAppointmentsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"appointment_id","patient_id","clinician_id","facility_id","appointment_date","appointment_time","duration_minutes","appointment_type","status","reason_for_visit","notes","created_date","last_modified"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Appointment a : model.getAllAppointments()) {
            tableModel.addRow(new Object[]{
                    a.getId(),
                    a.getPatientId(),
                    a.getClinicianId(),
                    a.getFacilityId(),
                    a.getAppointmentDate(),
                    a.getAppointmentTime(),
                    a.getDurationMinutes(),
                    a.getAppointmentType(),
                    a.getStatus(),
                    a.getReasonForVisit(),
                    a.getNotes(),
                    a.getCreatedDate(),
                    a.getLastModified()
            });
        }

        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Appointment"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Prescriptions =================
    private JPanel createPrescriptionsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"prescription_id","patient_id","clinician_id","appointment_id","prescription_date","medication_name","dosage","frequency","duration_days","quantity","instructions","pharmacy_name","status","issue_date","collection_date"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Prescription p : model.getAllPrescriptions()) {
            tableModel.addRow(new Object[]{
                    p.getId(),
                    p.getPatientId(),
                    p.getClinicId(),
                    p.getAppointmentId(),
                    p.getPrescriptionDate(),
                    p.getMedicationName(),
                    p.getDosage(),
                    p.getFrequency(),
                    p.getDurationDays(),
                    p.getQuantity(),
                    p.getInstructions(),
                    p.getPharmacyName(),
                    p.getStatus(),
                    p.getIssueDate(),
                    p.getCollection()
            });
        }

        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Prescription"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Referrals =================
    private JPanel createReferralsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"referral_id","patient_id","referring_clinician_id","referred_to_clinician_id","referring_facility_id","referred_to_facility_id","referral_date","urgency_level","referral_reason","clinical_summary","requested_investigations","status","appointment_id","notes","created_date","last_updated"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Referral r : model.getAllReferrals()) {
            tableModel.addRow(new Object[]{
                    r.getId(),
                    r.getPatientId(),
                    r.getReferringClinicianId(),
                    r.getReferredToClinicianId(),
                    r.getReferringFacilityId(),
                    r.getReferredToFacilityId(),
                    r.getReferralDate(),
                    r.getUrgencyLevel(),
                    r.getReferralReason(),
                    r.getClinicianSummary(),
                    r.getRequestedInvestigations(),
                    r.getStatus(),
                    r.getAppointmentId(),
                    r.getNotes(),
                    r.getCreatedDate(),
                    r.getLastUpdated()
            });
        }

        JTable table = new JTable(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Referral"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Shared Buttons =================
    private JPanel createButtonPanel(String entityName) {
        JPanel panel = new JPanel();

        JButton addButton = new JButton("Add " + entityName);
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        // For now, just placeholders
        addButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Add " + entityName + " clicked"));

        editButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Edit " + entityName + " clicked"));

        deleteButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Delete " + entityName + " clicked"));

        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);

        return panel;
    }
}
