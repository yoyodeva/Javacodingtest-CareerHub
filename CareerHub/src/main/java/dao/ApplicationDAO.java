package dao;

import java.util.List;
import com.CareerHub.model.*;
public interface ApplicationDAO {
    void addApplication(Application application);
    void updateApplication(Application application);
    void deleteApplication(int applicationId);
    Application getApplicationById(int applicationId);
    List<Application> getAllApplications();
}
