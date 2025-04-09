package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.CareerHub.model.Job;
import util.DBConnection;

public class JobDAOImpl implements JobDAO {

    @Override
    public void addJob(Job job) {
        String sql = "INSERT INTO Jobs (JobID, CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, job.getJobId());
            stmt.setInt(2, job.getCompanyId());
            stmt.setString(3, job.getJobTitle());
            stmt.setString(4, job.getJobDescription());
            stmt.setString(5, job.getJobLocation());
            stmt.setDouble(6, job.getSalary());
            stmt.setString(7, job.getJobType());
            stmt.setDate(8, new java.sql.Date(job.getPostedDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateJob(Job job) {
        String sql = "UPDATE Jobs SET CompanyID = ?, JobTitle = ?, JobDescription = ?, JobLocation = ?, Salary = ?, JobType = ?, PostedDate = ? WHERE JobID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, job.getCompanyId());
            stmt.setString(2, job.getJobTitle());
            stmt.setString(3, job.getJobDescription());
            stmt.setString(4, job.getJobLocation());
            stmt.setDouble(5, job.getSalary());
            stmt.setString(6, job.getJobType());
            stmt.setDate(7, new java.sql.Date(job.getPostedDate().getTime()));
            stmt.setInt(8, job.getJobId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteJob(int jobId) {
        String sql = "DELETE FROM Jobs WHERE JobID = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, jobId);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Job deleted successfully.");
            } else {
                System.out.println("No job found with ID: " + jobId);
            }

        } catch (SQLException e) {
            System.err.println("Error deleting job with ID " + jobId);
            e.printStackTrace();
        }
    }


    @Override
    public Job getJobById(int jobId) {
        String sql = "SELECT * FROM Jobs WHERE JobID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, jobId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Job(
                    rs.getInt("JobID"),
                    rs.getInt("CompanyID"),
                    rs.getString("JobTitle"),
                    rs.getString("JobDescription"),
                    rs.getString("JobLocation"),
                    rs.getDouble("Salary"),
                    rs.getString("JobType"),
                    rs.getDate("PostedDate")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM Jobs";
        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                jobs.add(new Job(
                    rs.getInt("JobID"),
                    rs.getInt("CompanyID"),
                    rs.getString("JobTitle"),
                    rs.getString("JobDescription"),
                    rs.getString("JobLocation"),
                    rs.getDouble("Salary"),
                    rs.getString("JobType"),
                    rs.getDate("PostedDate")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }
}
