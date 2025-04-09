package dao;

import java.util.List;
import com.CareerHub.model.*;
public interface ApplicantDAO {
    void addApplicant(Applicant applicant);
    void updateApplicant(Applicant applicant);
    void deleteApplicant(int applicantId);
    Applicant getApplicantById(int applicantId);
    List<Applicant> getAllApplicants();
}
