package lib;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

/* Unit testing usint JUnit
 * 
 * Unit tesing for addRemark()
 * the method names corresponds to what consraint is put to test.
 */

public class RemarkTest {
    //Test 1
    @Test
    public void PerfectRemark1(){
        //all constraints are correct for remark and type
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");


        assertEquals(prescription.addRemark("The patient seems to recovering, although going directly outside the sun may affect vision", "optometrist"), true);
    }


    @Test
    public void PerfectRemark2(){
        //all constraints are correct for remark and type
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        prescription.addRemark("The patient seems to recovering, although going directly outside the sun may affect vision", "optometrist");
        assertEquals(prescription. addRemark("My eyesight have been deteriorating and It is difficult to see far away objects.", "client"), true);
    }

    //Test 2
    @Test
    public void LessNumberofWordsinReview1(){
        //remark with words less than 6
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

            

        assertEquals(prescription.addRemark("Hello", "optometrist"), false);
    }
    @Test
    public void LessNumberofWordsinReview2(){
        //remark with words exactly 6

        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

            

        assertEquals(prescription.addRemark("Thank you", "optometrist"), false);
    }

    //Test 3
    @Test
    public void MoreNumberofWordsinReview1(){
        //remark with more than 20 words
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("The patient seems to be recovering, and the described medication to reduce the pain in the eyes are provided, the patient is advised to not go outside in the sun as eyes are still very sensitive to deal with the harmful rays.", "optometrist"), false);
    }
    @Test
    public void MoreNumberofWordsinReview2(){
        //remark with more than 20 words
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("Please note that the medication provided by the prescription seems to be having an allergic reaction to my skin, is there a way to provide with a different medication pertaining to the same condition regarding my eyes, as it’s causing excessive rashes", "optometrist"), false);
    }

    //Test 4
    @Test
    public void WrongTypeForReview1(){
        // review type set to Nurse
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("Thankyou very much for providing with the medication for relieving pain", "nurse"), false);
    }
    @Test
    public void WrongTypeForReview2(){
        //review type set to Teacher
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("“Please note that the you have some misconception, regarding the solution I provided", "teacher"), false);
    }

    //Test 5
    @Test
    public void ClientWritesPerfectReview1(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("Thankyou very much for providing with the medication for relieving pain", "client"), true);
    }
    @Test
    public void ClientWritesPerfectReview2(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        assertEquals(prescription.addRemark("My eyes seems to be setting well to the glasses provided by the prescription", "client"), true);
    }

    //Test 6
    @Test
    public void AddingInvalidNumbersOfRewiews1(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        prescription.addRemark("The patient is prescribed with a pain killer to reduce the pain in the eye", "optometrist");
        prescription.addRemark("The patient is also advised to not go outside in the sun immediately.", "optometrist");

        assertEquals(prescription.addRemark("Thankyou very much for providing with the medication for relieving pain", "client"), false);
    }
    @Test
    public void AddingInvalidNumbersOfRewiews2(){
        Prescription prescription = new Prescription("Pratyaksh", "Basel", "123 Scape La Trobe St, Melbourne",
                10, -2, 90, "14/10/24", "Dr. Suresh Kumar");

        prescription.addRemark("It’s a lovely day to go to a doctor to get my eyes checked", "client");
        prescription.addRemark("Your eyes are dry from the way I perceive, I would recommend you to use some eye drops", "optometrist");

        assertEquals(prescription.addRemark("I have been taking the eye drops provided by you and they seem to be working well.", "client"), false);
    }
}

