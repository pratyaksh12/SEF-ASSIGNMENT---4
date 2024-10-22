
/*
 * this file is responsible for console based program
 * 
 */
package lib;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input prescription details
        System.out.println("Enter the first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the address: ");
        String address = scanner.nextLine();
        System.out.println("Enter the sphere: ");
        float sphere = scanner.nextFloat();
        System.out.println("Enter the cylinder: ");
        float cylinder = scanner.nextFloat();
        System.out.println("Enter the axis: ");
        float axis = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Enter the appointment date (dd/MM/yy): ");
        String date_str = scanner.nextLine();
        System.out.println("Enter the optometrist's name: ");
        String optometrist = scanner.nextLine();

        // Create a prescription object
        Prescription prescription = new Prescription(firstName, lastName, address, sphere, cylinder, axis, date_str,
                optometrist);

        // Try to add the prescription
        if (prescription.addPrescription()) {
            System.out.println("Prescription added successfully.");
            System.out.println("Do you want to add a remark? (yes/no)");
            String response = scanner.nextLine();
            while (response.equalsIgnoreCase("yes")) {
                System.out.println("Enter remark type (Client/Optometrist): ");
                String remarkType = scanner.nextLine();
                System.out.println("Enter the remark: ");
                String remark = scanner.nextLine();

                if (prescription.addRemark(remark, remarkType)) {
                    System.out.println("Remark added successfully.");
                } else {
                    System.out.println("Failed to add remark.");
                }

                System.out.println("Do you want to add another remark? (yes/no)");
                response = scanner.nextLine();
            }
        } else {
            System.out.println("Failed to add prescription.");
        }

        prescription.loadRemark();

        scanner.close();
    }

}
