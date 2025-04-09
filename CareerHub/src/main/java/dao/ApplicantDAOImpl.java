package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.CareerHub.model.*;
import util.*;

public class ApplicantDAOImpl implements ApplicantDAO {

    @Override
    public void addApplicant(Applicant applicant) {
        String sql = "INSERT INTO Applicants (ApplicantID, FirstName, LastName, Email, Phone, Resume) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1, applicant.getApplicantId());
            stmt.setString(2, applicant.getFirstName());
            stmt.setString(3, applicant.getLastName());
            stmt.setString(4, applicant.getEmail());
            stmt.setString(5, applicant.getPhone());
            stmt.setString(6, applicant.getResume());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateApplicant(Applicant applicant) {
        String sql = "UPDATE Applicants SET FirstName = ?, LastName = ?, Email = ?, Phone = ?, Resume = ? WHERE ApplicantID = ?";
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, applicant.getFirstName());
            stmt.setString(2, applicant.getLastName());
            stmt.setString(3, applicant.getEmail());
            stmt.setString(4, applicant.getPhone());
            stmt.setString(5, applicant.getResume());
            stmt.setInt(6, applicant.getApplicantId());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteApplicant(int applicantId) {
        String deleteApplicationsSql = "DELETE FROM Applications WHERE ApplicantID = ?";
        String deleteApplicantSql = "DELETE FROM Applicants WHERE ApplicantID = ?";

        try (Connection connection = DBConnection.getConnection()) {
            connection.setAutoCommit(false); 

            try (PreparedStatement deleteAppsStmt = connection.prepareStatement(deleteApplicationsSql);
                 PreparedStatement deleteApplicantStmt = connection.prepareStatement(deleteApplicantSql)) {

                deleteAppsStmt.setInt(1, applicantId);
                deleteAppsStmt.executeUpdate();

                deleteApplicantStmt.setInt(1, applicantId);
                int affectedRows = deleteApplicantStmt.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Applicant deleted successfully.");
                } else {
                    System.out.println("No applicant found with ID: " + applicantId);
                }

                connection.commit();
            } catch (SQLException e) {
                connection.rollback(); 
                System.err.println("Error deleting applicant and their applications.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.err.println("Database connection error while deleting applicant.");
            e.printStackTrace();
        }
    }

 


    @Override
    public Applicant getApplicantById(int applicantId) {
        String sql = "SELECT * FROM Applicants WHERE ApplicantID = ?";
        try (Connection connection = DBConnection.getConnection(); 
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setInt(1, applicantId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Applicant(
                    rs.getInt("ApplicantID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Email"),
                    rs.getString("Phone"),
                    rs.getString("Resume")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Applicant> getAllApplicants() {
        List<Applicant> applicants = new ArrayList<>();
        String sql = "SELECT * FROM Applicants";
        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                applicants.add(new Applicant(
                    rs.getInt("ApplicantID"),
                    rs.getString("FirstName"),
                    rs.getString("LastName"),
                    rs.getString("Email"),
                    rs.getString("Phone"),
                    rs.getString("Resume")
                ));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applicants;
    }
}
