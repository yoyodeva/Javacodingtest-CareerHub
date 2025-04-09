package service;

import java.util.List;
import java.sql.*;
import com.CareerHub.model.*;
import dao.ApplicantDAO;
public class ApplicantServiceImpl implements ApplicantService {
    private ApplicantDAO applicantDAO;

    public ApplicantServiceImpl(ApplicantDAO applicantDAO) {
        this.applicantDAO = applicantDAO;
    }

    @Override
    public void addApplicant(Applicant applicant) {
        applicantDAO.addApplicant(applicant);
    }

    @Override
    public void updateApplicant(Applicant applicant) {
        applicantDAO.updateApplicant(applicant);
    }

    @Override
    public void deleteApplicant(int applicantId) {
        applicantDAO.deleteApplicant(applicantId);
    }

    @Override
    public Applicant getApplicantById(int applicantId) {
        return applicantDAO.getApplicantById(applicantId);
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return applicantDAO.getAllApplicants();
    }
}

