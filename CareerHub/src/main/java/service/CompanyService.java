package service;

import java.util.List;
import com.CareerHub.model.*;
public interface CompanyService {
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int companyId);
    Company getCompanyById(int companyId);
    List<Company> getAllCompanies();
}
