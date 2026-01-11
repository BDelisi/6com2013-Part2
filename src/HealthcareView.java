import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

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


        String[] columns = {"facility_id","facility_name","facility_type","address","postcode","phone_number","email","opening_hours","manager_name",
                            "capacity","specialities_offered"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        ArrayList<Facility> facilityList = new ArrayList<>(model.getAllFacilities());
        facilityList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Facility f : facilityList) {
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

        tableModel.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            if (row < 0 || col < 0) return;

            Facility f = model.getFacilityById(tableModel.getValueAt(row, 0).toString()); // get original object
            Object newValue = tableModel.getValueAt(row, col);

            switch (col) {
                case 1: f.setFacilityName(newValue.toString()); break;
                case 2: f.setFacilityType(newValue.toString()); break;
                case 3: f.setAddress(newValue.toString()); break;
                case 4: f.setPostCode(newValue.toString()); break;
                case 5: f.setPhoneNumber(newValue.toString()); break;
                case 6: f.setEmail(newValue.toString()); break;
                case 7: f.setOpeningHours(newValue.toString()); break;
                case 8: f.setManagerName(newValue.toString()); break;
                case 9: break;
                case 10: f.setSpecialtiesOffered(newValue.toString()); break;
            }

            if (col == 9) { // assume capacity column index
                try {
                    f.setCapacity(Integer.parseInt(newValue.toString()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Capacity must be a number");
                    tableModel.setValueAt(0, row, 9);
                }
            }

            model.saveFacilities();
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Facility"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Clinicians =================
    private JPanel createCliniciansPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"clinician_id","first_name","last_name","title","speciality","gmc_number","phone_number","email","workplace_id",
                            "workplace_type","employment_status","start_date"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        ArrayList<Clinician> clinicianList = new ArrayList<>(model.getAllClinicians());
        clinicianList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Clinician c : clinicianList) {
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

        tableModel.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            if (row < 0 || col < 0) return;

            Clinician c = model.getClinicianById(tableModel.getValueAt(row, 0).toString()); // get original object
            Object newValue = tableModel.getValueAt(row, col);

            switch (col) {
                case 1: c.setFirstName(newValue.toString()); break;
                case 2: c.setLastName(newValue.toString()); break;
                case 3: c.setTitle(newValue.toString()); break;
                case 4: c.setSpecialty(newValue.toString()); break;
                case 5: c.setGmcNumber(newValue.toString()); break;
                case 6: c.setPhoneNumber(newValue.toString()); break;
                case 7: c.setEmail(newValue.toString()); break;
                case 8: c.setWorkPlaceId(newValue.toString()); break;
                case 9: c.setWorkPlaceType(newValue.toString()); break;
                case 10: c.setEmploymentStatus(newValue.toString()); break;
                case 11: c.setStartDate(newValue.toString()); break;
            }

            model.saveClinicians();
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Clinician"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Patients =================
    private JPanel createPatientsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"patient_id","first_name","last_name","date_of_birth","nhs_number","gender","phone_number","email","address",
                            "postcode","emergency_contact_name","emergency_contact_phone","registration_date","gp_surgery_id"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        ArrayList<Patient> patientList = new ArrayList<>(model.getAllPatients());
        patientList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Patient p : patientList) {
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

        tableModel.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            if (row < 0 || col < 0) return;

            Patient p = model.getPatientById(tableModel.getValueAt(row, 0).toString()); // get original object
            Object newValue = tableModel.getValueAt(row, col);

            switch (col) {
                case 1: p.setFirstName(newValue.toString()); break;
                case 2: p.setLastName(newValue.toString()); break;
                case 3: p.setDateOfBirth(newValue.toString()); break;
                case 4: p.setNhsNumber(newValue.toString()); break;
                case 5: p.setGender(newValue.toString()); break;
                case 6: p.setPhoneNumber(newValue.toString()); break;
                case 7: p.setEmail(newValue.toString()); break;
                case 8: p.setAddress(newValue.toString()); break;
                case 9: p.setPostCode(newValue.toString()); break;
                case 10: p.setEmergencyContactName(newValue.toString()); break;
                case 11: p.setEmergencyContactPhone(newValue.toString()); break;
                case 12: p.setRegistrationDate(newValue.toString()); break;
                case 13: p.setGpSurgeryId(newValue.toString()); break;
            }

            model.savePatients();
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Patient"), BorderLayout.SOUTH);
        return panel;
    }

    // =================== Staff ======================
    private JPanel createStaffPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"staff_id","first_name","last_name","role","department","facility_id","phone_number","email","employment_status",
                            "start_date","line_manager","access_level"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

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

        tableModel.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            if (row < 0 || col < 0) return;

            Staff s = model.getStaffById(tableModel.getValueAt(row, 0).toString()); // get original object
            Object newValue = tableModel.getValueAt(row, col);

            switch (col) {
                case 1: s.setFirstName(newValue.toString()); break;
                case 2: s.setLastName(newValue.toString()); break;
                case 3: s.setRole(newValue.toString()); break;
                case 4: s.setDepartment(newValue.toString()); break;
                case 5: s.setFacilityId(newValue.toString()); break;
                case 6: s.setPhoneNumber(newValue.toString()); break;
                case 7: s.setEmail(newValue.toString()); break;
                case 8: s.setEmploymentStatus(newValue.toString()); break;
                case 9: s.setStartDate(newValue.toString()); break;
                case 10: s.setLineManager(newValue.toString()); break;
                case 11: s.setAccessLevel(newValue.toString()); break;
            }

            model.saveStaff();
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Staff"), BorderLayout.SOUTH);
        return panel;
    }


    // ================= Appointments =================
    private JPanel createAppointmentsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"appointment_id","patient_id","clinician_id","facility_id","appointment_date","appointment_time","duration_minutes",
                            "appointment_type","status","reason_for_visit","notes","created_date","last_modified"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        ArrayList<Appointment> appointmentList = new ArrayList<>(model.getAllAppointments());
        appointmentList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Appointment a : appointmentList) {
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

        tableModel.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            if (row < 0 || col < 0) return;

            Appointment a = model.getAppointmentById(tableModel.getValueAt(row, 0).toString()); // get original object
            Object newValue = tableModel.getValueAt(row, col);

            switch (col) {
                case 1: a.setPatientId(newValue.toString()); break;
                case 2: a.setClinicianId(newValue.toString()); break;
                case 3: a.setFacilityId(newValue.toString()); break;
                case 4: a.setAppointmentDate(newValue.toString()); break;
                case 5: a.setAppointmentTime(newValue.toString()); break;
                case 6: break;
                case 7: a.setStatus(newValue.toString()); break;
                case 8: a.setReasonForVisit(newValue.toString()); break;
                case 9: a.setNotes(newValue.toString()); break;
                case 10: a.setCreatedDate(newValue.toString()); break;
                case 11: a.setLastModified(newValue.toString()); break;
            }

            if (col == 6) { // assume capacity column index
                try {
                    a.setDurationMinutes(Integer.parseInt(newValue.toString()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Duration must be a number");
                    tableModel.setValueAt(0, row, 6);
                }
            }

            model.saveAppointments();
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Appointment"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Prescriptions =================
    private JPanel createPrescriptionsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"prescription_id","patient_id","clinician_id","appointment_id","prescription_date","medication_name","dosage","frequency",
                            "duration_days","quantity","instructions","pharmacy_name","status","issue_date","collection_date"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        ArrayList<Prescription> prescriptionList = new ArrayList<>(model.getAllPrescriptions());
        prescriptionList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(2))));

        for (Prescription p : prescriptionList) {
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

        tableModel.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            if (row < 0 || col < 0) return;

            Prescription p = model.getPrescriptionById(tableModel.getValueAt(row, 0).toString()); // get original object
            Object newValue = tableModel.getValueAt(row, col);

            switch (col) {
                case 1: p.setPatientId(newValue.toString()); break;
                case 2: p.setClinicId(newValue.toString()); break;
                case 3: p.setAppointmentId(newValue.toString()); break;
                case 4: p.setPrescriptionDate(newValue.toString()); break;
                case 5: p.setMedicationName(newValue.toString()); break;
                case 6: p.setDosage(newValue.toString()); break;
                case 7: p.setFrequency(newValue.toString()); break;
                case 8: break;
                case 9: p.setQuantity(newValue.toString()); break;
                case 10: p.setInstructions(newValue.toString()); break;
                case 11: p.setPharmacyName(newValue.toString()); break;
                case 12: p.setStatus(newValue.toString()); break;
                case 13: p.setIssueDate(newValue.toString()); break;
                case 14: p.setCollection(newValue.toString()); break;
            }

            if (col == 8) { // assume capacity column index
                try {
                    p.setDurationDays(Integer.parseInt(newValue.toString()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Duration must be a number");
                    tableModel.setValueAt(0, row, 8);
                }
            }

            model.savePrescriptions();
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Prescription"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Referrals =================
    private JPanel createReferralsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"referral_id","patient_id","referring_clinician_id","referred_to_clinician_id","referring_facility_id","referred_to_facility_id",
                            "referral_date","urgency_level","referral_reason","clinical_summary","requested_investigations","status","appointment_id","notes",
                            "created_date","last_updated"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        ArrayList<Referral> referralList = new ArrayList<>(model.getAllReferrals());
        referralList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Referral r : referralList) {
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

        tableModel.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();
            if (row < 0 || col < 0) return;

            Referral r = model.getReferralById(tableModel.getValueAt(row, 0).toString()); // get original object
            Object newValue = tableModel.getValueAt(row, col);

            switch (col) {
                case 1: r.setPatientId(newValue.toString()); break;
                case 2: r.setReferringClinicianId(newValue.toString()); break;
                case 3: r.setReferredToClinicianId(newValue.toString()); break;
                case 4: r.setReferringFacilityId(newValue.toString()); break;
                case 5: r.setReferredToFacilityId(newValue.toString()); break;
                case 6: r.setReferralDate(newValue.toString()); break;
                case 7: r.setUrgencyLevel(newValue.toString()); break;
                case 8: r.setReferralReason(newValue.toString()); break;
                case 9: r.setClinicianSummary(newValue.toString()); break;
                case 10: r.setRequestedInvestigations(newValue.toString()); break;
                case 11: r.setStatus(newValue.toString()); break;
                case 12: r.setAppointmentId(newValue.toString()); break;
                case 13: r.setNotes(newValue.toString()); break;
                case 15: r.setLastUpdated(newValue.toString()); break;
            }

            model.saveReferrals();
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Referral"), BorderLayout.SOUTH);
        return panel;
    }

    // ================= Shared Buttons =================
    private JPanel createButtonPanel(String entityName) {
        JPanel panel = new JPanel();

        JButton addButton = new JButton("Add " + entityName);
        JButton deleteButton = new JButton("Delete");

        // For now, just placeholders
        addButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Add " + entityName + " clicked"));

        deleteButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this, "Delete " + entityName + " clicked"));

        panel.add(addButton);
        panel.add(deleteButton);

        return panel;
    }
}
