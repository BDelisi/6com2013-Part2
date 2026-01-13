import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthcareController {
    private HealthcareModel model;
    private HealthcareView view;
    private ReferralManager referralManager;

    public HealthcareController(HealthcareModel model, HealthcareView view) {
        this.model = model;
        this.view = view;

        this.referralManager = ReferralManager.getInstance(model);

        setupView();
        setupListeners();
    }

    public void setupView() {
        view.createFacilitiesPanel(model.getAllFacilities());
        view.createCliniciansPanel(model.getAllClinicians());
        view.createPatientsPanel(model.getAllPatients());
        view.createStaffPanel(model.getAllStaff());
        view.createAppointmentsPanel(model.getAllAppointments());
        view.createPrescriptionsPanel(model.getAllPrescriptions());
        view.createReferralsPanel(model.getAllReferrals());
    }

    public void setupListeners() {
        view.setFacilitiesPanelListener(new TableUpdateListener() {
            public void onTableChange(TableModelEvent e, DefaultTableModel tableModel) {
                handleUpdateFacilities(e, tableModel);
            }
        });

        view.setCliniciansPanelListener(new TableUpdateListener() {
            public void onTableChange(TableModelEvent e, DefaultTableModel tableModel) {
                handleUpdateClinicians(e, tableModel);
            }
        });

        view.setPatientsPanelListener(new TableUpdateListener() {
            public void onTableChange(TableModelEvent e, DefaultTableModel tableModel) {
                handleUpdatePatients(e, tableModel);
            }
        });
        view.setStaffPanelListener(new TableUpdateListener() {
            public void onTableChange(TableModelEvent e, DefaultTableModel tableModel) {
                handleUpdateStaff(e, tableModel);
            }
        });
        view.setAppointmentsPanelListener(new TableUpdateListener() {
            public void onTableChange(TableModelEvent e, DefaultTableModel tableModel) {
                handleUpdateAppointments(e, tableModel);
            }
        });
        view.setPrescriptionsPanelListener(new TableUpdateListener() {
            public void onTableChange(TableModelEvent e, DefaultTableModel tableModel) {
                handleUpdatePrescriptions(e, tableModel);
            }
        });
        view.setReferralsPanelListener(new TableUpdateListener() {
            public void onTableChange(TableModelEvent e, DefaultTableModel tableModel) {
                handleUpdateReferrals(e, tableModel);
            }
        });
        view.setDeleteButtonListener(new DeleteButtonListener() {
            public void onDelete(String entityName, DefaultTableModel tableModel, JTable table) {
                handleDeleteObject(entityName, tableModel, table);
            }

        });
        view.setCreateButtonListener(new CreateButtonListener() {
            public void onCreate(String entityName) {
                handleCreateObject(entityName);
            }
        });
    }

    public void handleUpdateFacilities(TableModelEvent e, DefaultTableModel tableModel) {
        int row = e.getFirstRow();
        int col = e.getColumn();
        if (row < 0 || col < 0) return;

        Facility f = model.getFacilityById(tableModel.getValueAt(row, 0).toString());
        Object newValue = tableModel.getValueAt(row, col);

        switch (col) {
            case 1:
                f.setFacilityName(newValue.toString());
                break;
            case 2:
                f.setFacilityType(newValue.toString());
                break;
            case 3:
                f.setAddress(newValue.toString());
                break;
            case 4:
                f.setPostCode(newValue.toString());
                break;
            case 5:
                f.setPhoneNumber(newValue.toString());
                break;
            case 6:
                f.setEmail(newValue.toString());
                break;
            case 7:
                f.setOpeningHours(newValue.toString());
                break;
            case 8:
                f.setManagerName(newValue.toString());
                break;
            case 9:
                break;
            case 10:
                f.setSpecialtiesOffered(newValue.toString());
                break;
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
    }


    public void handleUpdateClinicians(TableModelEvent e, DefaultTableModel tableModel) {
        int row = e.getFirstRow();
        int col = e.getColumn();
        if (row < 0 || col < 0) return;

        Clinician c = model.getClinicianById(tableModel.getValueAt(row, 0).toString());
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
            case 11: c.setStartDate(newValue.toString());break;
        }

        model.saveClinicians();
    }

    public void handleUpdatePatients(TableModelEvent e, DefaultTableModel tableModel) {
        int row = e.getFirstRow();
        int col = e.getColumn();
        if (row < 0 || col < 0) return;

        Patient p = model.getPatientById(tableModel.getValueAt(row, 0).toString());
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
    }
    public void handleUpdateStaff(TableModelEvent e, DefaultTableModel tableModel) {
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
    }
    public void handleUpdateAppointments(TableModelEvent e, DefaultTableModel tableModel) {
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
            case 7: a.setAppointmentType(newValue.toString()); break;
            case 8: a.setStatus(newValue.toString()); break;
            case 9: a.setReasonForVisit(newValue.toString()); break;
            case 10: a.setNotes(newValue.toString()); break;
            case 11: a.setCreatedDate(newValue.toString()); break;
        }

        if (col == 6) { // assume capacity column index
            try {
                a.setDurationMinutes(Integer.parseInt(newValue.toString()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Duration must be a number");
                tableModel.setValueAt(0, row, 6);
            }
        }
        a.setLastModified(model.getDate());
        model.saveAppointments();
        view.refreshAppointmentTable(model.getAllAppointments());
    }
    public void handleUpdatePrescriptions(TableModelEvent e, DefaultTableModel tableModel) {
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
    }
    public void handleUpdateReferrals(TableModelEvent e, DefaultTableModel tableModel) {
        int row = e.getFirstRow();
        int col = e.getColumn();
        if (row < 0 || col < 0) return;

        Referral r = model.getReferralById(tableModel.getValueAt(row, 0).toString());
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
        }
        r.setLastUpdated(model.getDate());
        model.saveReferrals();
        view.refreshReferralsTable(model.getAllReferrals());
    }

    public void handleCreateObject(String entityName) {
        switch (entityName) {
            case "Facility":
                model.addFacility(new Facility(model.generateFacilityId(),"","","","","","",
                                                "","",0,""));
                view.refreshFacilitiesTable(model.getAllFacilities());
                break;
            case "Patient":
                model.addPatient(new Patient(model.generatePatientId(),"","","","","","","",
                                            "","","","", model.getDate(),""));
                view.refreshPatientsTable(model.getAllPatients());
                break;
            case "Clinician":
                model.addClinician(new Clinician(model.generateClinicianId(),"","","","","","","",
                                                "","","", model.getDate()));
                view.refreshClinicianTable(model.getAllClinicians());
                break;
            case "Referral":
                referralManager.createReferral("", "", "", "", "", "Normal",
                                                "", "");
                view.refreshReferralsTable(model.getAllReferrals());
                break;
            case  "Staff":
                model.addStaff(new Staff(model.generateStaffId(),"","","","","","","","",
                                        model.getDate(),"",""));
                view.refreshStaffTable(model.getAllStaff());
                break;
            case "Prescription":
                model.addPrescription(new Prescription(model.generatePrescriptionId(),"","","", model.getDate(), "",
                                                    "","",0,"","","","Issued", model.getDate(),
                                                    ""));
                view.refreshPrescriptionTable(model.getAllPrescriptions());
                break;
            case "Appointment":
                model.addAppointment(new Appointment(model.generateAppointmentId(),"","","","","",
                                                    0,"","Scheduled","","", model.getDate(),
                                                    model.getDate()));
                view.refreshAppointmentTable(model.getAllAppointments());
                break;
        }
    }

    public void handleDeleteObject(String entityName, DefaultTableModel tableModel, JTable table) {
        switch (entityName) {
            case "Facility": model.removeFacilityById(tableModel.getValueAt(table.getSelectedRow(), 0).toString()); break;
            case "Patient": model.removePatientById(tableModel.getValueAt(table.getSelectedRow(), 0).toString()); break;
            case "Clinician": model.removeClinicianById(tableModel.getValueAt(table.getSelectedRow(), 0).toString()); break;
            case "Referral": model.removeReferralById(tableModel.getValueAt(table.getSelectedRow(), 0).toString()); break;
            case "Staff": model.removeStaffByID(tableModel.getValueAt(table.getSelectedRow(), 0).toString()); break;
            case "Prescription": model.removePrescriptionById(tableModel.getValueAt(table.getSelectedRow(), 0).toString()); break;
            case "Appointment": model.removeAppointmentById(tableModel.getValueAt(table.getSelectedRow(), 0).toString()); break;
        }
        tableModel.removeRow(table.getSelectedRow());
    }

    public String getGeneratedEmail(String referralID) {
        return referralManager.generateReferralEmail(model.getReferralById(referralID));
    }
}


interface TableUpdateListener {
    void onTableChange(TableModelEvent e, DefaultTableModel dtm);
}

interface DeleteButtonListener {
    void onDelete(String entityName, DefaultTableModel tableModel, JTable table);
}

interface CreateButtonListener {
    void onCreate(String entityName);
}