package dao;

import java.util.List;
import com.CareerHub.model.*;
public interface CompanyDAO {
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int companyId);
    Company getCompanyById(int companyId);
    List<Company> getAllCompanies();
}
