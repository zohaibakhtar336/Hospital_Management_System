import java.io.*;
import java.util.ArrayList;

public class Hospital {
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        loadDoctors();
        loadPatients();
    }

    // Add a doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        saveDoctors();
    }

    // List available doctors
    public void listAvailableDoctors() {
        boolean found = false;
        for (Doctor doctor : doctors) {
            if (doctor.isAvailable()) {
                System.out.println(doctor);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available doctors at the moment.");
        }
    }

    // Register new patient
    public void addPatient(Patient patient) {
        patients.add(patient);
        savePatients();
        System.out.println("Patient registered successfully!");
    }

    // Assign doctor to patient
    public void assignDoctorToPatient(String patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId().equals(patientId)) {
                for (Doctor doctor : doctors) {
                    if (doctor.isAvailable()) {
                        patient.assignDoctor(doctor);
                        System.out.println("Doctor " + doctor.getName() + " assigned to " + patient.getName());
                        saveDoctors();
                        return;
                    }
                }
                System.out.println("No doctors available.");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    // Discharge a patient
    public void dischargePatient(String patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId().equals(patientId)) {
                patient.discharge();
                patients.remove(patient);
                savePatients();
                saveDoctors();
                System.out.println("Patient discharged successfully.");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    // List all patients
    public void listPatients() {
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails());
        }
    }

    // Save & Load Data
    private void saveDoctors() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("doctors.dat"))) {
            oos.writeObject(doctors);
        } catch (Exception e) {
            System.out.println("Error saving doctors data.");
        }
    }

    private void loadDoctors() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("doctors.dat"))) {
            doctors = (ArrayList<Doctor>) ois.readObject();
        } catch (Exception e) {
            System.out.println("No existing doctor data found.");
        }
    }

    private void savePatients() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("patients.dat"))) {
            oos.writeObject(patients);
        } catch (Exception e) {
            System.out.println("Error saving patient data.");
        }
    }

    private void loadPatients() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("patients.dat"))) {
            patients = (ArrayList<Patient>) ois.readObject();
        } catch (Exception e) {
            System.out.println("No existing patient data found.");
        }
    }
}
