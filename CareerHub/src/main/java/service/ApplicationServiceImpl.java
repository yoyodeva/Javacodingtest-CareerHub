package service;

import java.util.List;
import com.CareerHub.model.Application;
import dao.ApplicationDAO;
import dao.ApplicationDAOImpl; 

public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationDAO applicationDAO;

    
    public ApplicationServiceImpl() {
        this.applicationDAO = new ApplicationDAOImpl(); 
    }

   
    public ApplicationServiceImpl(ApplicationDAO applicationDAO) {
        this.applicationDAO = applicationDAO;
    }

    @Override
    public void addApplication(Application application) {
        applicationDAO.addApplication(application);
    }

    @Override
    public void updateApplication(Application application) {
        applicationDAO.updateApplication(application);
    }

    @Override
    public void deleteApplication(int applicationId) {
        applicationDAO.deleteApplication(applicationId);
    }

    @Override
    public Application getApplicationById(int applicationId) {
        return applicationDAO.getApplicationById(applicationId);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationDAO.getAllApplications();
    }
}
