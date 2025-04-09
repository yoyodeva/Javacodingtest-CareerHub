package service;

import java.util.List;
import com.CareerHub.model.*;
public interface ApplicantService {
    void addApplicant(Applicant applicant);
    void updateApplicant(Applicant applicant);
    void deleteApplicant(int applicantId);
    Applicant getApplicantById(int applicantId);
    List<Applicant> getAllApplicants();
}
