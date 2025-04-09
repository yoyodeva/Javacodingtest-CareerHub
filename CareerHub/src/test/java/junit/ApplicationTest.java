package junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import com.CareerHub.model.*;

public class ApplicationTest {

    private Application application;
    private Date applicationDate;

    @Before
    public void setUp() {
        applicationDate = new Date();
        application = new Application();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(application);
    }

    @Test
    public void testParameterizedConstructor() {
        String coverLetter = "I am very excited to apply for this position!";
        Application application = new Application(201, 101, 501, applicationDate, coverLetter);

        assertEquals(201, application.getApplicationId());
        assertEquals(101, application.getJobId());
        assertEquals(501, application.getApplicantId());
        assertEquals(applicationDate, application.getApplicationDate());
        assertEquals(coverLetter, application.getCoverLetter());
    }

    @Test
    public void testSetAndGetApplicationId() {
        application.setApplicationId(202);
        assertEquals(202, application.getApplicationId());
    }

    @Test
    public void testSetAndGetJobId() {
        application.setJobId(102);
        assertEquals(102, application.getJobId());
    }

    @Test
    public void testSetAndGetApplicantId() {
        application.setApplicantId(502);
        assertEquals(502, application.getApplicantId());
    }

    @Test
    public void testSetAndGetApplicationDate() {
        Date date = new Date();
        application.setApplicationDate(date);
        assertEquals(date, application.getApplicationDate());
    }

    @Test
    public void testSetAndGetCoverLetter() {
        String coverLetter = "I believe I am a great fit for this job!";
        application.setCoverLetter(coverLetter);
        assertEquals(coverLetter, application.getCoverLetter());
    }

    @Test
    public void testToString() {
        String coverLetter = "I'm highly interested in this job position.";
        application = new Application(203, 103, 503, applicationDate, coverLetter);

        String expected = "Application [applicationId=203, jobId=103, applicantId=503"
                          + ", applicationDate=" + applicationDate + ", coverLetter=" + coverLetter + "]";

        assertEquals(expected, application.toString());
    }
}
