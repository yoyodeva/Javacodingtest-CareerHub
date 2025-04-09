package service;

import java.util.List;
import java.sql.*;
import dao.CompanyDAO;
import com.CareerHub.model.*;
public class CompanyServiceImpl implements CompanyService {
    private CompanyDAO companyDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public void addCompany(Company company) {
        companyDAO.addCompany(company);
    }

    @Override
    public void updateCompany(Company company) {
        companyDAO.updateCompany(company);
    }

    @Override
    public void deleteCompany(int companyId) {
        companyDAO.deleteCompany(companyId);
    }

    @Override
    public Company getCompanyById(int companyId) {
        return companyDAO.getCompanyById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }
}
