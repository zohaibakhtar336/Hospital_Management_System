public class Patient {
    private static int patientCounter = 500;
    private String patientId;
    private String name;
    private int age;
    private String disease;
    private Doctor assignedDoctor;

    public Patient(String name, int age, String disease) {
        this.patientId = "P" + patientCounter++;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.assignedDoctor = null;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    public void assignDoctor(Doctor doctor) {
        this.assignedDoctor = doctor;
        doctor.setAvailable(false);
    }

    public void discharge() {
        if (assignedDoctor != null) {
            assignedDoctor.setAvailable(true);
        }
    }

    public String getPatientDetails() {
        return "[Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Disease: " + disease + 
               (assignedDoctor != null ? ", Assigned Doctor: " + assignedDoctor.getName() : ", No Doctor Assigned") + "]";
    }
}