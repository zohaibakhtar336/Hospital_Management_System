public class Doctor {

    private static int doctorCounter = 100;
    private String doctorId;
    private String name;
    private String specialization;
    private boolean isAvailable;

    public Doctor(String name, String specialization) {
        this.doctorId = "D" + doctorCounter++;
        this.name = name;
        this.specialization = specialization;
        this.isAvailable = true;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "[Doctor ID: " + doctorId + ", Name: " + name + ", Specialization: " + specialization
                + ", Available: " + (isAvailable ? "Yes" : "No") + "]";
    }
}
