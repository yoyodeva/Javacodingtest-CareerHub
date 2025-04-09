package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.CareerHub.model.Company;
import util.DBConnection;

public class CompanyDAOImpl implements CompanyDAO {

    @Override
    public void addCompany(Company company) {
        String sql = "INSERT INTO Companies (CompanyID, CompanyName, Location) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, company.getCompanyID());
            stmt.setString(2, company.getCompanyName());
            stmt.setString(3, company.getLocation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCompany(Company company) {
        String sql = "UPDATE Companies SET CompanyName = ?, Location = ? WHERE CompanyID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, company.getCompanyName());
            stmt.setString(2, company.getLocation());
            stmt.setInt(3, company.getCompanyID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(int companyId) {
        String deleteJobsSql = "DELETE FROM Jobs WHERE CompanyID = ?";
        String deleteCompanySql = "DELETE FROM Companies WHERE CompanyID = ?";

        try (Connection connection = DBConnection.getConnection()) {
            connection.setAutoCommit(false); 

            try (PreparedStatement deleteJobsStmt = connection.prepareStatement(deleteJobsSql);
                 PreparedStatement deleteCompanyStmt = connection.prepareStatement(deleteCompanySql)) {

                deleteJobsStmt.setInt(1, companyId);
                deleteJobsStmt.executeUpdate();

                deleteCompanyStmt.setInt(1, companyId);
                deleteCompanyStmt.executeUpdate();

                connection.commit(); 
            } catch (SQLException e) {
                connection.rollback(); 
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    @Override
    public Company getCompanyById(int companyId) {
        String sql = "SELECT * FROM Companies WHERE CompanyID = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, companyId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Company(
                    rs.getInt("CompanyID"),
                    rs.getString("CompanyName"),
                    rs.getString("Location")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM Companies";
        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                companies.add(new Company(
                    rs.getInt("CompanyID"),
                    rs.getString("CompanyName"),
                    rs.getString("Location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }
}
