package com.CareerHub.model;
import java.util.Date;

public class Application {
    private int applicationId;
    private int jobId;
    private int applicantId;
    private Date applicationDate;
    private String coverLetter;

    public Application() {
    }

    public Application(int applicationId, int jobId, int applicantId, Date applicationDate, String coverLetter) {
        this.applicationId = applicationId;
        this.jobId = jobId;
        this.applicantId = applicantId;
        this.applicationDate = applicationDate;
        this.coverLetter = coverLetter;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    @Override
    public String toString() {
        return "Application [applicationId=" + applicationId + ", jobId=" + jobId + ", applicantId=" + applicantId 
                + ", applicationDate=" + applicationDate + ", coverLetter=" + coverLetter + "]";
    }
}
