package main;

import service.*;
import dao.*;
import com.CareerHub.model.*;
import exception.*;
import java.util.List;
import java.util.Scanner;

public class CareerHubApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CompanyDAO companyDAO = new CompanyDAOImpl();
        CompanyService companyService = new CompanyServiceImpl(companyDAO);
        JobDAO jobDAO = new JobDAOImpl();
        JobService jobService = new JobServiceImpl(jobDAO);
        ApplicantDAO applicantDAO = new ApplicantDAOImpl();
        ApplicantService applicantService = new ApplicantServiceImpl(applicantDAO);
        ApplicationDAO applicationDAO = new ApplicationDAOImpl();
        ApplicationService applicationService = new ApplicationServiceImpl(applicationDAO);

        int choice;
        do {
            System.out.println("\n=== CareerHub Job Portal ===");
            System.out.println("1. Manage Companies");
            System.out.println("2. Manage Jobs");
            System.out.println("3. Manage Applicants");
            System.out.println("4. Manage Applications");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    manageCompanies(sc, companyService);
                    break;
                case 2:
                    manageJobs(sc, jobService);
                    break;
                case 3:
                    manageApplicants(sc, applicantService);
                    break;
                case 4:
                    manageApplications(sc, applicationService);
                    break;
                case 5:
                    System.out.println("Thank you for using CareerHub!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }

    private static void manageCompanies(Scanner sc, CompanyService companyService) {
        int choice;
        do {
            System.out.println("\n--- Company Management ---");
            System.out.println("1. Add Company");
            System.out.println("2. View All Companies");
            System.out.println("3. Update Company");
            System.out.println("4. Delete Company");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    Company company = new Company();
                    System.out.print("Enter Company ID: ");
                    company.setCompanyID(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter Company Name: ");
                    company.setCompanyName(sc.nextLine());
                    System.out.print("Enter Location: ");
                    company.setLocation(sc.nextLine());
                    companyService.addCompany(company);
                    System.out.println("Company added successfully!");
                    break;
                case 2:
                    List<Company> companies = companyService.getAllCompanies();
                    for (Company comp : companies) {
                        System.out.println(comp);
                    }
                    break;
                case 3:
                    System.out.print("Enter Company ID to update: ");
                    int compId = sc.nextInt();
                    sc.nextLine();
                    Company compToUpdate = companyService.getCompanyById(compId);
                    if (compToUpdate != null) {
                        System.out.print("Enter New Company Name: ");
                        compToUpdate.setCompanyName(sc.nextLine());
                        System.out.print("Enter New Location: ");
                        compToUpdate.setLocation(sc.nextLine());
                        companyService.updateCompany(compToUpdate);
                        System.out.println("Company updated successfully!");
                    } else {
                        System.out.println("Company not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Company ID to delete: ");
                    int deleteCompId = sc.nextInt();
                    companyService.deleteCompany(deleteCompId);
                    System.out.println("Company deleted successfully!");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    private static void manageJobs(Scanner sc, JobService jobService) {
        int choice;
        do {
            System.out.println("\n--- Job Management ---");
            System.out.println("1. Add Job");
            System.out.println("2. View All Jobs");
            System.out.println("3. Update Job");
            System.out.println("4. Delete Job");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    Job job = new Job();
                    System.out.print("Enter Job ID: ");
                    job.setJobId(sc.nextInt());
                    System.out.print("Enter Company ID: ");
                    job.setCompanyId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter Job Title: ");
                    job.setJobTitle(sc.nextLine());
                    System.out.print("Enter Job Description: ");
                    job.setJobDescription(sc.nextLine());
                    System.out.print("Enter Job Location: ");
                    job.setJobLocation(sc.nextLine());
                    System.out.print("Enter Salary: ");
                    job.setSalary(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Enter Job Type: ");
                    job.setJobType(sc.nextLine());
                    job.setPostedDate(new java.util.Date());
                    jobService.addJob(job);
                    System.out.println("Job added successfully!");
                    break;
                case 2:
                    List<Job> jobs = jobService.getAllJobs();
                    for (Job j : jobs) {
                        System.out.println(j);
                    }
                    break;
                case 3:
                    System.out.print("Enter Job ID to update: ");
                    int jobId = sc.nextInt();
                    sc.nextLine();
                    Job jobToUpdate = jobService.getJobById(jobId);
                    if (jobToUpdate != null) {
                        System.out.print("Enter New Job Title: ");
                        jobToUpdate.setJobTitle(sc.nextLine());
                        System.out.print("Enter New Job Description: ");
                        jobToUpdate.setJobDescription(sc.nextLine());
                        System.out.print("Enter New Job Location: ");
                        jobToUpdate.setJobLocation(sc.nextLine());
                        System.out.print("Enter New Salary: ");
                        jobToUpdate.setSalary(sc.nextDouble());
                        sc.nextLine();
                        System.out.print("Enter New Job Type: ");
                        jobToUpdate.setJobType(sc.nextLine());
                        jobService.updateJob(jobToUpdate);
                        System.out.println("Job updated successfully!");
                    } else {
                        System.out.println("Job not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Job ID to delete: ");
                    int deleteJobId = sc.nextInt();
                    jobService.deleteJob(deleteJobId);
                    System.out.println("Job deleted successfully!");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    private static void manageApplicants(Scanner sc, ApplicantService applicantService) {
        int choice;
        do {
            System.out.println("\n--- Applicant Management ---");
            System.out.println("1. Add Applicant");
            System.out.println("2. View All Applicants");
            System.out.println("3. Update Applicant");
            System.out.println("4. Delete Applicant");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    Applicant applicant = new Applicant();
                    System.out.print("Enter Applicant ID: ");
                    applicant.setApplicantId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter First Name: ");
                    applicant.setFirstName(sc.nextLine());
                    System.out.print("Enter Last Name: ");
                    applicant.setLastName(sc.nextLine());
                    System.out.print("Enter Email: ");
                    applicant.setEmail(sc.nextLine());
                    System.out.print("Enter Phone: ");
                    applicant.setPhone(sc.nextLine());
                    System.out.print("Enter Resume URL: ");
                    applicant.setResume(sc.nextLine());
                    applicantService.addApplicant(applicant);
                    System.out.println("Applicant added successfully!");
                    break;
                case 2:
                    List<Applicant> applicants = applicantService.getAllApplicants();
                    for (Applicant a : applicants) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    System.out.print("Enter Applicant ID to update: ");
                    int applicantId = sc.nextInt();
                    sc.nextLine();
                    Applicant applicantToUpdate = applicantService.getApplicantById(applicantId);
                    if (applicantToUpdate != null) {
                        System.out.print("Enter New First Name: ");
                        applicantToUpdate.setFirstName(sc.nextLine());
                        System.out.print("Enter New Last Name: ");
                        applicantToUpdate.setLastName(sc.nextLine());
                        System.out.print("Enter New Email: ");
                        applicantToUpdate.setEmail(sc.nextLine());
                        System.out.print("Enter New Phone: ");
                        applicantToUpdate.setPhone(sc.nextLine());
                        System.out.print("Enter New Resume URL: ");
                        applicantToUpdate.setResume(sc.nextLine());
                        applicantService.updateApplicant(applicantToUpdate);
                        System.out.println("Applicant updated successfully!");
                    } else {
                        System.out.println("Applicant not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Applicant ID to delete: ");
                    int deleteApplicantId = sc.nextInt();
                    applicantService.deleteApplicant(deleteApplicantId);
                    System.out.println("Applicant deleted successfully!");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    private static void manageApplications(Scanner sc, ApplicationService applicationService) {
        int choice;
        do {
            System.out.println("\n--- Application Management ---");
            System.out.println("1. Add Application");
            System.out.println("2. View All Applications");
            System.out.println("3. Update Application");
            System.out.println("4. Delete Application");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    Application application = new Application();
                    System.out.print("Enter Application ID: ");
                    application.setApplicationId(sc.nextInt());
                    System.out.print("Enter Job ID: ");
                    application.setJobId(sc.nextInt());
                    System.out.print("Enter Applicant ID: ");
                    application.setApplicantId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter Application Date: ");
                    application.setApplicationDate(new java.util.Date());
                    System.out.print("Enter Cover Letter: ");
                    application.setCoverLetter(sc.nextLine());
                    applicationService.addApplication(application);
                    System.out.println("Application submitted successfully!");
                    break;
                case 2:
                    List<Application> applications = applicationService.getAllApplications();
                    for (Application app : applications) {
                        System.out.println(app);
                    }
                    break;
                case 3:
                    System.out.print("Enter Application ID to update: ");
                    int applicationId = sc.nextInt();
                    sc.nextLine();
                    Application appToUpdate = applicationService.getApplicationById(applicationId);
                    if (appToUpdate != null) {
                        System.out.print("Enter New Cover Letter: ");
                        appToUpdate.setCoverLetter(sc.nextLine());
                        applicationService.updateApplication(appToUpdate);
                        System.out.println("Application updated successfully!");
                    } else {
                        System.out.println("Application not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Application ID to delete: ");
                    int deleteApplicationId = sc.nextInt();
                    applicationService.deleteApplication(deleteApplicationId);
                    System.out.println("Application deleted successfully!");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
