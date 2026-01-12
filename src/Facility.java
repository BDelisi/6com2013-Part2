import java.util.Vector;

public class Facility {
    private String id;
    private String facilityName;
    private String facilityType;
    private String address;
    private String postCode;
    private String phoneNumber;
    private String email;
    private String openingHours;
    private String managerName;
    private int capacity;
    private String specialtiesOffered;

    public Facility(String id, String facilityName, String facilityType, String address, String postCode, String phoneNumber, String email, String openingHours, String managerName, int capacity, String specialtiesOffered) {
        this.id = id;
        this.facilityName = facilityName;
        this.facilityType = facilityType;
        this.address = address;
        this.postCode = postCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.openingHours = openingHours;
        this.managerName = managerName;
        this.capacity = capacity;
        this.specialtiesOffered = specialtiesOffered;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSpecialtiesOffered() {
        return specialtiesOffered;
    }

    public void setSpecialtiesOffered(String specialtiesOffered) {
        this.specialtiesOffered = specialtiesOffered;
    }

    public static Facility fromCSV(String csv) {
        Vector<String> parts =CSVHandler.smartSplit(csv);
        return new Facility(parts.get(0), parts.get(1), parts.get(2), parts.get(3), parts.get(4), parts.get(5), parts.get(6), parts.get(7), parts.get(8), Integer.parseInt(parts.get(9)), parts.get(10));
    }

    @Override
    public String toString() {
        return id + "," + facilityName + "," + facilityType + "," + address + "," + postCode + "," + phoneNumber + "," + email + "," + openingHours + "," + managerName + "," + capacity + "," + specialtiesOffered;
    }
}
