package junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;
import com.CareerHub.model.*;

public class JobTest {

    private Job job;
    private Date postedDate;

    @Before
    public void setUp() {
        postedDate = new Date();
        job = new Job();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(job);
    }

    @Test
    public void testParameterizedConstructor() {
        Job job = new Job(101, 1, "Software Engineer", "Develop applications", "New York", 
                          85000.00, "Full-time", postedDate);

        assertEquals(101, job.getJobId());
        assertEquals(1, job.getCompanyId());
        assertEquals("Software Engineer", job.getJobTitle());
        assertEquals("Develop applications", job.getJobDescription());
        assertEquals("New York", job.getJobLocation());
        assertEquals(85000.00, job.getSalary(), 0.001);
        assertEquals("Full-time", job.getJobType());
        assertEquals(postedDate, job.getPostedDate());
    }

    @Test
    public void testSetAndGetJobId() {
        job.setJobId(102);
        assertEquals(102, job.getJobId());
    }

    @Test
    public void testSetAndGetCompanyId() {
        job.setCompanyId(2);
        assertEquals(2, job.getCompanyId());
    }

    @Test
    public void testSetAndGetJobTitle() {
        job.setJobTitle("Data Analyst");
        assertEquals("Data Analyst", job.getJobTitle());
    }

    @Test
    public void testSetAndGetJobDescription() {
        job.setJobDescription("Analyze data and create reports");
        assertEquals("Analyze data and create reports", job.getJobDescription());
    }

    @Test
    public void testSetAndGetJobLocation() {
        job.setJobLocation("San Francisco");
        assertEquals("San Francisco", job.getJobLocation());
    }

    @Test
    public void testSetAndGetSalary() {
        job.setSalary(75000.50);
        assertEquals(75000.50, job.getSalary(), 0.001);
    }

    @Test
    public void testSetAndGetJobType() {
        job.setJobType("Part-time");
        assertEquals("Part-time", job.getJobType());
    }

    @Test
    public void testSetAndGetPostedDate() {
        Date date = new Date();
        job.setPostedDate(date);
        assertEquals(date, job.getPostedDate());
    }

    @Test
    public void testToString() {
        job = new Job(103, 3, "Backend Developer", "Work on server-side logic", 
                      "Boston", 92000.00, "Full-time", postedDate);

        String expected = "Job [jobId=103, companyId=3, jobTitle=Backend Developer"
                        + ", jobDescription=Work on server-side logic, jobLocation=Boston"
                        + ", salary=92000.0, jobType=Full-time, postedDate=" + postedDate + "]";

        assertEquals(expected, job.toString());
    }
}
