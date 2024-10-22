package lib;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class RemarkTest {
    //Test 1
    @Test
    public void PerfectRemark1(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");


        assertEquals(prescription.addRemark("The patient seems to recovering, although going directly outside the sun may affect vision", "Optometrist"), true);
    }


    @Test
    public void PerfectRemark2(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        prescription.addRemark("The patient seems to recovering, although going directly outside the sun may affect vision", "Optometrist");
        assertEquals(prescription. addRemark("My eyesight have been deteriorating and It is difficult to see far away objects.", "Client"), true);
    }

    //Test 2
    @Test
    public void LessNumberofWordsinReview1(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

            

        assertEquals(prescription.addRemark("Hello", "Optometrist"), false);
    }
    @Test
    public void LessNumberofWordsinReview2(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

            

        assertEquals(prescription.addRemark("Thank you", "Optometrist"), false);
    }

    //Test 3
    @Test
    public void MoreNumberofWordsinReview1(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("The patient seems to be recovering, and the described medication to reduce the pain in the eyes are provided, the patient is advised to not go outside in the sun as eyes are still very sensitive to deal with the harmful rays.", "Optometrist"), false);
    }
    @Test
    public void MoreNumberofWordsinReview2(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("Please note that the medication provided by the prescription seems to be having an allergic reaction to my skin, is there a way to provide with a different medication pertaining to the same condition regarding my eyes, as it’s causing excessive rashes", "Optometrist"), false);
    }

    //Test 4
    @Test
    public void WrongTypeForReview1(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("Thankyou very much for providing with the medication for relieving pain", "Nurse"), false);
    }
    @Test
    public void WrongTypeForReview2(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("“Please note that the you have some misconception, regarding the solution I provided", "Teacher"), false);
    }

    //Test 5
    @Test
    public void ClientWritesPerfectReview1(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("Thankyou very much for providing with the medication for relieving pain", "Client"), true);
    }
    @Test
    public void ClientWritesPerfectReview2(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("My eyes seems to be setting well to the glasses provided by the prescription", "client"), false);
    }

    //Test 6
    @Test
    public void AddingInvalidNumbersOfRewiews1(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        prescription.addRemark("The patient is prescribed with a pain killer to reduce the pain in the eye", "Optometrist");
        prescription.addRemark("The patient is also advised to not go outside in the sun immediately.", "Optometrist");

        assertEquals(prescription.addRemark("Thankyou very much for providing with the medication for relieving pain", "Client"), false);
    }
    @Test
    public void AddingInvalidNumbersOfRewiews2(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        prescription.addRemark("It’s a lovely day to go to a doctor to get my eyes checked", "Client");
        prescription.addRemark("Your eyes are dry from the way I perceive, I would recommend you to use some eye drops", "Optometrist");

        assertEquals(prescription.addRemark("I have been taking the eye drops provided by you and they seem to be working well.", "Client"), false);
    }
}

