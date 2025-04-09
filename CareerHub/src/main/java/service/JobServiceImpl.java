package service;

import java.util.List;
import dao.JobDAO;
import dao.JobDAOImpl;
import com.CareerHub.model.*;

public class JobServiceImpl implements JobService {
    private JobDAO jobDAO;  

    public JobServiceImpl() {
        this.jobDAO = new JobDAOImpl();  
    }

    public JobServiceImpl(JobDAO jobDAO) {
        this.jobDAO = jobDAO;  
    }

    @Override
    public void addJob(Job job) {
        jobDAO.addJob(job);
    }

    @Override
    public void updateJob(Job job) {
        jobDAO.updateJob(job);
    }

    @Override
    public void deleteJob(int jobId) {
        jobDAO.deleteJob(jobId);
    }

    @Override
    public Job getJobById(int jobId) {
        return jobDAO.getJobById(jobId);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobDAO.getAllJobs();
    }
}
