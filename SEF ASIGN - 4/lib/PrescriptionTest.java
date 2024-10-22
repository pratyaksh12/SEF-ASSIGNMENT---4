package lib;

import static org.junit.Assert.assertEquals;
import org.junit.Test;



public class PrescriptionTest {

    //Test case 1
    @Test
    public void PerfectPrescription1() {

        Prescription prescription = new Prescription(
                "Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), true);

    }
    @Test
    public void PerfectPrescription2() {

        Prescription prescription = new Prescription(
                "Someone", "Name", "Gandhi Nagar, Agra, India Noida Colony",
                15, 0, 120, "11/05/24", "Dr. Alan Jackson");

        assertEquals(prescription.addPrescription(), true);

    }
    //Test case 2
    @Test
    public void PrescriptionWithBothNameLessThan4_1() {
        Prescription prescription = new Prescription(
                "123", "234", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);

    }
    @Test
    public void PrescriptionWithBothNameLessThan4_2() {
        Prescription prescription = new Prescription(
                "Name", "234", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);

    }


    //Test case 3
    @Test
    public void PrescriptionWithAddressLess20_1() {

        Prescription prescription = new Prescription(
                "Someone", "Name", "Scape La Trobe",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);
    }
    @Test
    public void PrescriptionWithAddressLess20_2() {

        Prescription prescription = new Prescription(
                "Someone", "Name", "Australia",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);
    }

    //Test case 4
    @Test
    public void PrescriptionWithInvalidSphericalData_1() {
        Prescription prescription = new Prescription(
                "Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                -21, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);
    }
    @Test
    public void PrescriptionWithInvalidSphericalData_2() {
        Prescription prescription = new Prescription(
                "Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                21, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);
    }

    //Test case 5
    @Test
    public void PrescriptionWithInvalidDate1() {
        Prescription prescription = new Prescription(
                "Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/14/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);
    }
    @Test
    public void PrescriptionWithInvalidDate2() {
        Prescription prescription = new Prescription(
                "Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "31/11/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);
    }

    //Test case 6
    @Test
    public void PrescriptionWithInvalidDateFormat1() {
        Prescription prescription = new Prescription(
                "Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -5, 90, "14-10-24", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);
    }
    @Test
    public void PrescriptionWithInvalidDateFormat2() {
        Prescription prescription = new Prescription(
                "Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -5, 90, "14-11-05", "Dr. Suresh Kumar");

        assertEquals(prescription.addPrescription(), false);
    }
}
