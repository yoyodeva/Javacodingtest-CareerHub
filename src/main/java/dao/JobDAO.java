package dao;

import java.util.List;
import com.CareerHub.model.*;
public interface JobDAO {
    void addJob(Job job);
    void updateJob(Job job);
    void deleteJob(int jobId);
    Job getJobById(int jobId);
    List<Job> getAllJobs();
}
