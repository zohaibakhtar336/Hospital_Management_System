import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("\n1. List Available Doctors");
            System.out.println("2. Register New Patient");
            System.out.println("3. Assign Doctor to Patient");
            System.out.println("4. List All Patients");
            System.out.println("5. Discharge Patient");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    hospital.listAvailableDoctors();
                    break;
                case 2:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter disease: ");
                    String disease = scanner.nextLine();
                    hospital.addPatient(new Patient(name, age, disease));
                    break;
                case 3:
                    System.out.print("Enter Patient ID: ");
                    hospital.assignDoctorToPatient(scanner.nextLine());
                    break;
                case 4:
                    hospital.listPatients();
                    break;
                case 5:
                    System.out.print("Enter Patient ID: ");
                    hospital.dischargePatient(scanner.nextLine());
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
