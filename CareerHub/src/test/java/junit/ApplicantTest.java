package junit;

import static org.junit.Assert.*;
import com.CareerHub.model.*;
import org.junit.Before;
import org.junit.Test;

public class ApplicantTest {

    private Applicant applicant;

    @Before
    public void setUp() {
        applicant = new Applicant();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(applicant);
    }

    @Test
    public void testParameterizedConstructor() {
        Applicant applicant = new Applicant(301, "John", "Doe", "john.doe@example.com", "1234567890", "resume.pdf");

        assertEquals(301, applicant.getApplicantId());
        assertEquals("John", applicant.getFirstName());
        assertEquals("Doe", applicant.getLastName());
        assertEquals("john.doe@example.com", applicant.getEmail());
        assertEquals("1234567890", applicant.getPhone());
        assertEquals("resume.pdf", applicant.getResume());
    }

    @Test
    public void testSetAndGetApplicantId() {
        applicant.setApplicantId(302);
        assertEquals(302, applicant.getApplicantId());
    }

    @Test
    public void testSetAndGetFirstName() {
        applicant.setFirstName("Alice");
        assertEquals("Alice", applicant.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        applicant.setLastName("Smith");
        assertEquals("Smith", applicant.getLastName());
    }

    @Test
    public void testSetAndGetEmail() {
        applicant.setEmail("alice.smith@example.com");
        assertEquals("alice.smith@example.com", applicant.getEmail());
    }

    @Test
    public void testSetAndGetPhone() {
        applicant.setPhone("0987654321");
        assertEquals("0987654321", applicant.getPhone());
    }

    @Test
    public void testSetAndGetResume() {
        applicant.setResume("alice_resume.pdf");
        assertEquals("alice_resume.pdf", applicant.getResume());
    }

    @Test
    public void testToString() {
        applicant = new Applicant(303, "Bob", "Johnson", "bob.johnson@example.com", "1122334455", "bob_resume.pdf");

        String expected = "Applicant [applicantId=303, firstName=Bob, lastName=Johnson, email=bob.johnson@example.com, "
                        + "phone=1122334455, resume=bob_resume.pdf]";
        
        assertEquals(expected, applicant.toString());
    }
}
