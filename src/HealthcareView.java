import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalDate;

public class HealthcareView extends JFrame {

    private HealthcareController controller;

    private JTabbedPane tabbedPane;
    private DefaultTableModel facilitiesTable;
    private DefaultTableModel cliniciansTable;
    private DefaultTableModel patientsTable;
    private DefaultTableModel staffTable;
    private DefaultTableModel appointmentsTable;
    private DefaultTableModel prescriptionsTable;
    private DefaultTableModel referralsTable;

    private TableUpdateListener facilitiesPanelListener;
    private TableUpdateListener cliniciansPanelListener;
    private TableUpdateListener patientsPanelListener;
    private TableUpdateListener staffPanelListener;
    private TableUpdateListener appointmentsPanelListener;
    private TableUpdateListener prescriptionsPanelListener;
    private TableUpdateListener referralsPanelListener;
    private CreateButtonListener createButtonListener;
    private DeleteButtonListener deleteButtonListener;


    public HealthcareView() {


        setTitle("Healthcare Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        add(tabbedPane);
    }

    public void setController(HealthcareController controller) {
        this.controller = controller;
    }

    // ================= Facilities ===============
    public void createFacilitiesPanel(ArrayList<Facility> facilities) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Facilities");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columns = {"facility_id","facility_name","facility_type","address","postcode","phone_number","email","opening_hours","manager_name",
                            "capacity","specialities_offered"};
        facilitiesTable = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        refreshFacilitiesTable(facilities);
        JTable table = new JTable(facilitiesTable);

        facilitiesTable.addTableModelListener( e ->{
            if (facilitiesPanelListener != null) {
                facilitiesPanelListener.onTableChange(e, facilitiesTable);
            }
        });


        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Facility", facilitiesTable, table), BorderLayout.SOUTH);
        tabbedPane.addTab("Facility", panel);
    }

    public void refreshFacilitiesTable(ArrayList<Facility> facilities){
        facilitiesTable.setRowCount(0);
        ArrayList<Facility> facilityList = new ArrayList<>(facilities);
        facilityList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Facility f : facilityList) {
            facilitiesTable.addRow(new Object[]{
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
    }

    // ================= Clinicians =================
    public void createCliniciansPanel(ArrayList<Clinician> clinician) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Clinicians");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columns = {"clinician_id","first_name","last_name","title","speciality","gmc_number","phone_number","email","workplace_id",
                            "workplace_type","employment_status","start_date"};
        cliniciansTable = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        refreshClinicianTable(clinician);

        JTable table = new JTable(cliniciansTable);

        cliniciansTable.addTableModelListener(e -> {
            if(cliniciansPanelListener != null) {
                cliniciansPanelListener.onTableChange(e, cliniciansTable);
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Clinician", cliniciansTable, table), BorderLayout.SOUTH);
        tabbedPane.addTab("Clinicians", panel);
    }

    public void refreshClinicianTable(ArrayList<Clinician> clinicians){
        cliniciansTable.setRowCount(0);
        ArrayList<Clinician> clinicianList = new ArrayList<>(clinicians);
        clinicianList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Clinician c : clinicianList) {
            cliniciansTable.addRow(new Object[]{
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
    }

    // ================= Patients =================
    public void createPatientsPanel(ArrayList<Patient> patients) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Patients");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columns = {"patient_id","first_name","last_name","date_of_birth","nhs_number","gender","phone_number","email","address",
                            "postcode","emergency_contact_name","emergency_contact_phone","registration_date","gp_surgery_id"};
        patientsTable = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        refreshPatientsTable(patients);

        JTable table = new JTable(patientsTable);

        patientsTable.addTableModelListener(e -> {
            if(patientsPanelListener != null) {
                patientsPanelListener.onTableChange(e, patientsTable);
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Patient", patientsTable, table), BorderLayout.SOUTH);
        tabbedPane.addTab("Patients", panel);
    }

    public void refreshPatientsTable(ArrayList<Patient> patients){
        patientsTable.setRowCount(0);
        ArrayList<Patient> patientList = new ArrayList<>(patients);
        patientList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Patient p : patientList) {
            patientsTable.addRow(new Object[]{
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
    }

    // =================== Staff ======================
    public void createStaffPanel(ArrayList<Staff> staff) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Staff");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columns = {"staff_id","first_name","last_name","role","department","facility_id","phone_number","email","employment_status",
                            "start_date","line_manager","access_level"};
        staffTable = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        refreshStaffTable(staff);

        JTable table = new JTable(staffTable);

        staffTable.addTableModelListener(e -> {
            if(staffPanelListener != null) {
                staffPanelListener.onTableChange(e, staffTable);
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Staff", staffTable, table), BorderLayout.SOUTH);
        tabbedPane.addTab("Staff", panel);
    }

    public void refreshStaffTable(ArrayList<Staff> staff){
        staffTable.setRowCount(0);
        ArrayList<Staff> staffList = new ArrayList<>(staff);
        staffList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(2))));

        for (Staff s : staffList) {
            staffTable.addRow(new Object[]{
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
    }


    // ================= Appointments =================
    public void createAppointmentsPanel(ArrayList<Appointment> appointments) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Appointments");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columns = {"appointment_id","patient_id","clinician_id","facility_id","appointment_date","appointment_time","duration_minutes",
                            "appointment_type","status","reason_for_visit","notes","created_date","last_modified"};
        appointmentsTable = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0 && column != 12;
            }
        };

       refreshAppointmentTable(appointments);

        JTable table = new JTable(appointmentsTable);

        appointmentsTable.addTableModelListener(e -> {
            if(appointmentsPanelListener != null) {
                appointmentsPanelListener.onTableChange(e, appointmentsTable);
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Appointment", appointmentsTable, table), BorderLayout.SOUTH);
        tabbedPane.addTab("Appointments", panel);
    }

    public void refreshAppointmentTable(ArrayList<Appointment> appointments){
        appointmentsTable.setRowCount(0);
        ArrayList<Appointment> appointmentList = new ArrayList<>(appointments);
        appointmentList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Appointment a : appointmentList) {
            appointmentsTable.addRow(new Object[]{
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
    }

    // ================= Prescriptions =================
    public void createPrescriptionsPanel(ArrayList<Prescription> prescriptions) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Prescriptions");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columns = {"prescription_id","patient_id","clinician_id","appointment_id","prescription_date","medication_name","dosage","frequency",
                            "duration_days","quantity","instructions","pharmacy_name","status","issue_date","collection_date"};
        prescriptionsTable = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        refreshPrescriptionTable(prescriptions);

        JTable table = new JTable(prescriptionsTable);

        prescriptionsTable.addTableModelListener(e -> {
            if(prescriptionsPanelListener != null) {
                prescriptionsPanelListener.onTableChange(e, prescriptionsTable);
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Prescription", prescriptionsTable, table), BorderLayout.SOUTH);
        tabbedPane.addTab("Prescriptions", panel);
    }

    public void refreshPrescriptionTable(ArrayList<Prescription> prescriptions){
        prescriptionsTable.setRowCount(0);
        ArrayList<Prescription> prescriptionList = new ArrayList<>(prescriptions);
        prescriptionList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(2))));

        for (Prescription p : prescriptionList) {
            prescriptionsTable.addRow(new Object[]{
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
    }

    // ================= Referrals =================
    public void createReferralsPanel(ArrayList<Referral> referrals) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Referrals");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        String[] columns = {"referral_id","patient_id","referring_clinician_id","referred_to_clinician_id","referring_facility_id","referred_to_facility_id",
                            "referral_date","urgency_level","referral_reason","clinical_summary","requested_investigations","status","appointment_id","notes",
                            "created_date","last_updated"};
        referralsTable = new DefaultTableModel(columns, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0 && column != 14 && column != 15;
            }
        };

        refreshReferralsTable(referrals);

        JTable table = new JTable(referralsTable);

        referralsTable.addTableModelListener(e -> {
            if(referralsPanelListener != null) {
                referralsPanelListener.onTableChange(e, referralsTable);
            }
        });

        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        panel.add(createButtonPanel("Referral", referralsTable, table), BorderLayout.SOUTH);
        tabbedPane.addTab("Referrals", panel);
    }

    public void refreshReferralsTable(ArrayList<Referral> referrals) {
        referralsTable.setRowCount(0);
        ArrayList<Referral> referralList = new ArrayList<>(referrals);
        referralList.sort(Comparator.comparingInt(r -> Integer.parseInt(r.getId().substring(1))));

        for (Referral r : referralList) {
            referralsTable.addRow(new Object[]{
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
    }

    private void showGeneratedEmailDialog(String referralId) {
        JDialog dialog = new JDialog(this, "Generated email", true);
        dialog.setSize(400, 400);
        dialog.setLocationRelativeTo(this);

        dialog.add(new JLabel("Generated email:"));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(controller.getGeneratedEmail(referralId));

        dialog.add(textArea);
        dialog.setVisible(true);
    }

    // ================= Shared Buttons =================
    private JPanel createButtonPanel(String entityName, DefaultTableModel tableModel, JTable table) {
        JPanel panel = new JPanel();

        JButton addButton = new JButton("Add " + entityName);
        JButton deleteButton = new JButton("Delete");

        addButton.addActionListener(e -> {
           if (createButtonListener != null) {
               createButtonListener.onCreate(entityName);
           }
        });


        deleteButton.addActionListener(e -> {
            if(deleteButtonListener != null) {
               try {
                   deleteButtonListener.onDelete(entityName, tableModel, table);
               } catch (Exception e1) {
                    showErrorMessage("Please select a valid " + entityName + " to delete");
               }
            }
        });

        panel.add(addButton);
        panel.add(deleteButton);

        if(entityName.equals("Referral")) {
            JButton emailButton = new JButton("Generate email");
            emailButton.addActionListener(e -> {
                try {
                    showGeneratedEmailDialog(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
                } catch (Exception e1) {
                    showErrorMessage("Please select a valid referral");
                }
            });
            panel.add(emailButton);
        }

        return panel;
    }

    // ================= Listener Setup =================
    public void setFacilitiesPanelListener(TableUpdateListener facilitiesPanelListener) {
        this.facilitiesPanelListener = facilitiesPanelListener;
    }

    public void setCliniciansPanelListener(TableUpdateListener cliniciansPanelListener) {
        this.cliniciansPanelListener = cliniciansPanelListener;
    }

    public void setPatientsPanelListener(TableUpdateListener patientsPanelListener) {
        this.patientsPanelListener = patientsPanelListener;
    }

    public void setStaffPanelListener(TableUpdateListener staffPanelListener) {
        this.staffPanelListener = staffPanelListener;
    }

    public void setAppointmentsPanelListener(TableUpdateListener appointmentsPanelListener) {
        this.appointmentsPanelListener = appointmentsPanelListener;
    }

    public void setPrescriptionsPanelListener(TableUpdateListener prescriptionsPanelListener) {
        this.prescriptionsPanelListener = prescriptionsPanelListener;
    }

    public void setReferralsPanelListener(TableUpdateListener referralsPanelListener) {
        this.referralsPanelListener = referralsPanelListener;
    }

    public void setCreateButtonListener(CreateButtonListener createButtonListener) {
        this.createButtonListener = createButtonListener;
    }

    public void setDeleteButtonListener(DeleteButtonListener deleteButtonListener) {
        this.deleteButtonListener = deleteButtonListener;
    }

    // ========== Utility Methods ==========

    public void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
