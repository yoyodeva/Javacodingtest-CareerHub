package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.CareerHub.model.Application;
import util.DBConnection;

public class ApplicationDAOImpl implements ApplicationDAO {
    private Connection connection;

    

    @Override
    public void addApplication(Application application) {
        String sql = "INSERT INTO Applications (ApplicationID, JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
        		PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, application.getApplicationId());
            stmt.setInt(2, application.getJobId());
            stmt.setInt(3, application.getApplicantId());
            stmt.setDate(4, new java.sql.Date(application.getApplicationDate().getTime()));  // Fix casting issue
            stmt.setString(5, application.getCoverLetter());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateApplication(Application application) {
        String sql = "UPDATE Applications SET JobID = ?, ApplicantID = ?, ApplicationDate = ?, CoverLetter = ? WHERE ApplicationID = ?";
        try (Connection connection = DBConnection.getConnection();
        		PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, application.getJobId());
            stmt.setInt(2, application.getApplicantId());
            stmt.setDate(3, new java.sql.Date(application.getApplicationDate().getTime()));
            stmt.setString(4, application.getCoverLetter());
            stmt.setInt(5, application.getApplicationId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteApplication(int applicationId) {
        String sql = "DELETE FROM Applications WHERE ApplicationID = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, applicationId);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Application deleted successfully.");
            } else {
                System.out.println("No application found with ID: " + applicationId);
            }

        } catch (SQLException e) {
            System.err.println("Error deleting application with ID " + applicationId);
            e.printStackTrace();
        }
    }


    @Override
    public Application getApplicationById(int applicationId) {
        String sql = "SELECT * FROM Applications WHERE ApplicationID = ?";
        try (Connection connection = DBConnection.getConnection();
        		PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, applicationId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Application(
                    rs.getInt("ApplicationID"),
                    rs.getInt("JobID"),
                    rs.getInt("ApplicantID"),
                    rs.getDate("ApplicationDate"),
                    rs.getString("CoverLetter")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Application> getAllApplications() {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT * FROM Applications";
        try (Connection connection = DBConnection.getConnection();
        		Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                applications.add(new Application(
                    rs.getInt("ApplicationID"),
                    rs.getInt("JobID"),
                    rs.getInt("ApplicantID"),
                    rs.getDate("ApplicationDate"),
                    rs.getString("CoverLetter")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }
}
