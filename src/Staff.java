import java.util.Vector;

public class Staff extends Person {
    private String role;
    private String department;
    private String facilityId;
    private String employmentStatus;
    private String startDate;
    private String lineManager;
    private String accessLevel;

    public Staff(String id, String firstName, String lastName, String role, String department, String facilityId, String phoneNumber, String email, String employmentStatus, String startDate, String lineManager, String accessLevel) {
        super(id, firstName, lastName, phoneNumber, email);
        this.role = role;
        this.department = department;
        this.facilityId = facilityId;
        this.employmentStatus = employmentStatus;
        this.startDate = startDate;
        this.lineManager = lineManager;
        this.accessLevel = accessLevel;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getLineManager() {
        return lineManager;
    }

    public void setLineManager(String lineManager) {
        this.lineManager = lineManager;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public static Staff fromCSV(String csv) {
        Vector<String> parts =CSVHandler.smartSplit(csv);
        return new Staff(parts.get(0), parts.get(1), parts.get(2), parts.get(3), parts.get(4), parts.get(5), parts.get(6), parts.get(7), parts.get(8), parts.get(9), parts.get(10), parts.get(11));
    }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + role + "," + department + "," + facilityId + "," + phoneNumber + "," + email + "," + employmentStatus + "," + startDate + "," + lineManager + "," + accessLevel;
    }
}
