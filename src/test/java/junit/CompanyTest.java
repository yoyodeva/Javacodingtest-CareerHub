package junit ;


import static org.junit.Assert.*;
import com.CareerHub.model.*;
import org.junit.Before;
import org.junit.Test;

public class CompanyTest {

    private Company company;

    @Before
    public void setUp() {
        company = new Company();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(company);
    }

    @Test
    public void testParameterizedConstructor() {
        Company company = new Company(1, "TechCorp", "New York");
        assertEquals(1, company.getCompanyID());
        assertEquals("TechCorp", company.getCompanyName());
        assertEquals("New York", company.getLocation());
    }

    @Test
    public void testSetAndGetCompanyID() {
        company.setCompanyID(2);
        assertEquals(2, company.getCompanyID());
    }

    @Test
    public void testSetAndGetCompanyName() {
        company.setCompanyName("CareerHub Inc");
        assertEquals("CareerHub Inc", company.getCompanyName());
    }

    @Test
    public void testSetAndGetLocation() {
        company.setLocation("Los Angeles");
        assertEquals("Los Angeles", company.getLocation());
    }

    @Test
    public void testToString() {
        company = new Company(3, "FutureWorks", "Chicago");
        String expected = "Company [companyID=3, companyName=FutureWorks, location=Chicago]";
        assertEquals(expected, company.toString());
    }
}
