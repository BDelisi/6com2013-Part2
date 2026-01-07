public class Patient extends Person {
    private String dateOfBirth;
    private String nhsNumber;
    private char gender;
    private String address;
    private String postCode;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String registrationDate;
    private String gpSurgeryId;

    public Patient(String id, String firstName, String lastName, String dateOfBirth, String nhsNumber, char gender, String phoneNumber, String email, String address, String postCode, String emergencyContactName, String emergencyContactPhone, String registrationDate, String gpSurgeryId) {
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
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
        String[] parts = csv.split(",");
        return new Patient(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5].charAt(0), parts[6], parts[7], parts[8] + "," + parts[9], parts[10], parts[11], parts[12], parts[13], parts[14]);
    }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + dateOfBirth + "," + nhsNumber + "," + gender + "," + phoneNumber + "," + email + "," + address + "," + postCode + "," + emergencyContactName + "," + emergencyContactPhone + "," + registrationDate + "," + gpSurgeryId;
    }
}
