import java.util.Vector;

public class Patient extends Person {
    private String dateOfBirth;
    private String nhsNumber;
    private String gender;
    private String address;
    private String postCode;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String registrationDate;
    private String gpSurgeryId;

    public Patient(String id, String firstName, String lastName, String dateOfBirth, String nhsNumber, String gender, String phoneNumber, String email, String address, String postCode, String emergencyContactName, String emergencyContactPhone, String registrationDate, String gpSurgeryId) {
        super(id, firstName, lastName, phoneNumber, email);
        this.dateOfBirth = dateOfBirth;
        this.nhsNumber = nhsNumber;
        this.gender = gender;
        this.address = address;
        this.postCode = postCode;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
        this.registrationDate = registrationDate;
        this.gpSurgeryId = gpSurgeryId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getGpSurgeryId() {
        return gpSurgeryId;
    }

    public void setGpSurgeryId(String gpSurgeryId) {
        this.gpSurgeryId = gpSurgeryId;
    }

    public static Patient fromCSV(String csv) {
        Vector<String> parts =CSVHandler.smartSplit(csv);
        return new Patient(parts.get(0), parts.get(1), parts.get(2), parts.get(3), parts.get(4), parts.get(5), parts.get(6), parts.get(7), parts.get(8), parts.get(9), parts.get(10), parts.get(11), parts.get(12), parts.get(13));
    }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + dateOfBirth + "," + nhsNumber + "," + gender + "," + phoneNumber + "," + email + "," + address + "," + postCode + "," + emergencyContactName + "," + emergencyContactPhone + "," + registrationDate + "," + gpSurgeryId;
    }
}
