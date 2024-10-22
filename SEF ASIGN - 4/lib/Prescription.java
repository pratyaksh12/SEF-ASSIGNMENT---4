package lib;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Prescription {
    // private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate;
    private String date_str;
    private String optometrist;
    private String[] remarkTypes = { "client", "optometrist" };
    private ArrayList<String> postRemarks = new ArrayList<>();

    // constructor

    public Prescription(String firstName, String lastName, String address, float sphere, float cylinder, float axis,
            String date_str, String optometrist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.date_str = date_str;
        this.optometrist = optometrist;
    }

    //adds the details in the prescription if results are valid

    public boolean addPrescription() {

        // check for constraint regarding the name
        if (firstName.length() < 4 || firstName.length() > 15 ||
                lastName.length() < 4 || lastName.length() > 15) {
            System.out.println("Name is too short or too large.");
            return false;
        }
        // check validity of address
        if (address.length() < 20) {
            System.out.println("address is too short.");
            return false;
        }

        // check validity of sphere
        if (sphere < -20 || sphere > 20) {
            System.out.println("Invalid sphere number.");
            return false;
        }
        // check validity of axis
        if (axis < 0 || axis > 180) {
            System.out.println("Invalid axis number.");
            return false;
        }
        // check validity of cylinder
        if (cylinder < -4 || cylinder > 4) {
            System.out.println("Invalid cylinder number");
            return false;
        }
        // check validity of length of optometrist name
        if (optometrist.length() < 8 || optometrist.length() > 25) {
            System.out.println("Optometris name is too short.");
            return false;
        }

        // try-catch to catch if the format of the date is wrong
        try {
            // check if the date is valid
            if (checkValidity(date_str)) {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
                examinationDate = format.parse(date_str);
            } else {
                System.out.println("Invalid date");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Invalid date format");
            return false;
        }

        // adding the data into the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("First Name: " + firstName);
            writer.newLine();
            writer.write("Last Name: " + lastName);
            writer.newLine();
            writer.write("Address: " + address);
            writer.newLine();
            writer.write("Sphere: " + sphere);
            writer.newLine();
            writer.write("Axis: " + axis);
            writer.newLine();
            writer.write("Cylinder: " + cylinder);
            writer.newLine();
            writer.write("Optometrist: " + optometrist);
            writer.newLine();
            writer.write("Appointment Date: " + examinationDate);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }



/*............................................................................................................................. */


    //writes remarks into the file.
    public boolean addRemark(String remark, String type) {
        // Ensure no more than 2 remarks can be added
        if (postRemarks.size() >= 2) {
            System.out.println("Cannot add more than 2 remarks.");
            return false;
        }
        // check if the type matches with the constraints
        if (!(type.equals(remarkTypes[0]) || type.equals(remarkTypes[1]))) {
            System.out.println("record can only be entered by a 'client' or a 'optomrtrist'");
            return false;
        }
        // check the number of words in the remark
        String[] remarkWords = remark.split(" ");
        if (remarkWords.length < 6 || remarkWords.length > 20) {
            System.out.println("Remark is too short or too large.");
            return false;
        }

        // add the remark to the list
        postRemarks.add("Rewiev added by " + type + ":\t" + remark);

        // load the remark in the file
        return loadRemark();

    }

    // helper function to write the remark onto the file
    public boolean loadRemark() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("review.txt"))) {
            
            for (String remark : postRemarks) {
                writer.write(remark);
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

    // helper function to validate date
    public boolean checkValidity(String date_str) {
        String[] check = date_str.split("/");

        int date_check = Integer.parseInt(check[0]);
        int month_check = Integer.parseInt(check[1]);
        int year_check = Integer.parseInt(check[2]);

        if (month_check < 1 || month_check > 12) {
            return false;
        }
        ;
        return date_check >= 1 && date_check <= daysInMonth(month_check, year_check);
    }

    // check for the number of days in certain months
    private int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                if (year % 4 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public static void main(String[] args) {
    }
    
}
