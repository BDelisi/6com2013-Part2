import java.util.Vector;

public class Clinician extends Person {
    private String title;
    private String specialty;
    private String gmcNumber;
    private String workPlaceId;
    private String workPlaceType;
    private String employmentStatus;
    private String startDate;

    public Clinician(String id, String firstName, String lastName, String title, String specialty, String gmcNumber, String phoneNumber, String email, String workPlaceId, String workPlaceType, String employmentStatus, String startDate) {
        super(id, firstName, lastName, phoneNumber, email);
        this.title = title;
        this.specialty = specialty;
        this.gmcNumber = gmcNumber;
        this.workPlaceId = workPlaceId;
        this.workPlaceType = workPlaceType;
        this.employmentStatus = employmentStatus;
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getGmcNumber() {
        return gmcNumber;
    }

    public void setGmcNumber(String gmcNumber) {
        this.gmcNumber = gmcNumber;
    }

    public String getWorkPlaceId() {
        return workPlaceId;
    }

    public void setWorkPlaceId(String workPlaceId) {
        this.workPlaceId = workPlaceId;
    }

    public String getWorkPlaceType() {
        return workPlaceType;
    }

    public void setWorkPlaceType(String workPlaceType) {
        this.workPlaceType = workPlaceType;
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

    public static Clinician fromCSV(String csv) {
        Vector<String> parts =CSVHandler.smartSplit(csv);
        return new Clinician(parts.get(0), parts.get(1), parts.get(2), parts.get(3), parts.get(4), parts.get(5), parts.get(6), parts.get(7), parts.get(8), parts.get(9), parts.get(10), parts.get(11));
    }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + title + "," + specialty + "," + gmcNumber + "," + phoneNumber + "," + email + "," + workPlaceId + "," + workPlaceType + "," + employmentStatus + "," + startDate;
    }
}
