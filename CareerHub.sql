Create database CareerHub;
use CareerHub;
CREATE TABLE Companies (
    CompanyID INT PRIMARY KEY,
    CompanyName VARCHAR(255) NOT NULL,
    Location VARCHAR(255) NOT NULL
);

CREATE TABLE Applicants (
    ApplicantID INT PRIMARY KEY,
    FirstName VARCHAR(100) NOT NULL,
    LastName VARCHAR(100) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Phone VARCHAR(20),
    Resume VARCHAR(255)
);


CREATE TABLE Jobs (
    JobID INT PRIMARY KEY,
    CompanyID INT,
    JobTitle VARCHAR(255) NOT NULL,
    JobDescription TEXT,
    JobLocation VARCHAR(255),
    Salary DECIMAL(10, 2),
    JobType VARCHAR(50),
    PostedDate DATETIME,
    FOREIGN KEY (CompanyID) REFERENCES Companies(CompanyID)
);

CREATE TABLE Applications (
    ApplicationID INT PRIMARY KEY,
    JobID INT,
    ApplicantID INT,
    ApplicationDate DATETIME,
    CoverLetter TEXT,
    FOREIGN KEY (JobID) REFERENCES Jobs(JobID),
    FOREIGN KEY (ApplicantID) REFERENCES Applicants(ApplicantID)
);

INSERT INTO Companies (CompanyID, CompanyName, Location) VALUES
(1, 'Hexaware Technologies', 'Mumbai'),
(2, 'TCS', 'Pune'),
(3, 'Infosys', 'Bangalore'),
(4, 'Wipro', 'Chennai'),
(5, 'Tech Mahindra', 'Hyderabad'),
(6, 'HCL Technologies', 'Noida'),
(7, 'Capgemini', 'Gurgaon'),
(8, 'Cognizant', 'Kolkata'),
(9, 'IBM India', 'Bangalore'),
(10, 'Accenture', 'Hyderabad');

INSERT INTO Jobs (JobID, CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES
(101, 1, 'Software Engineer', 'Develop and maintain software applications.', 'Mumbai', 600000, 'Full-time', '2025-04-01'),
(102, 2, 'Data Analyst', 'Analyze data and generate reports.', 'Pune', 550000, 'Full-time', '2025-04-02'),
(103, 3, 'System Administrator', 'Manage IT infrastructure.', 'Bangalore', 500000, 'Full-time', '2025-04-03'),
(104, 4, 'Java Developer', 'Develop Java applications.', 'Chennai', 620000, 'Full-time', '2025-04-04'),
(105, 5, 'Project Manager', 'Manage software projects.', 'Hyderabad', 900000, 'Full-time', '2025-04-05'),
(106, 6, 'UX Designer', 'Design user interfaces.', 'Noida', 580000, 'Contract', '2025-04-06'),
(107, 7, 'Cloud Engineer', 'Handle cloud services.', 'Gurgaon', 750000, 'Full-time', '2025-04-07'),
(108, 8, 'Technical Writer', 'Prepare technical documents.', 'Kolkata', 400000, 'Part-time', '2025-04-08'),
(109, 9, 'Business Analyst', 'Analyze business needs.', 'Bangalore', 670000, 'Full-time', '2025-04-09'),
(110, 10, 'QA Engineer', 'Test software products.', 'Hyderabad', 500000, 'Full-time', '2025-04-10');

INSERT INTO Applicants (ApplicantID, FirstName, LastName, Email, Phone, Resume) VALUES
(201, 'Amit', 'Sharma', 'amit.sharma@example.com', '9876543210', 'resume_amit.pdf'),
(202, 'Neha', 'Patel', 'neha.patel@example.com', '8765432109', 'resume_neha.pdf'),
(203, 'Rahul', 'Verma', 'rahul.verma@example.com', '7654321098', 'resume_rahul.pdf'),
(204, 'Priya', 'Singh', 'priya.singh@example.com', '6543210987', 'resume_priya.pdf'),
(205, 'Karan', 'Mehta', 'karan.mehta@example.com', '5432109876', 'resume_karan.pdf'),
(206, 'Simran', 'Gupta', 'simran.gupta@example.com', '4321098765', 'resume_simran.pdf'),
(207, 'Rohan', 'Kapoor', 'rohan.kapoor@example.com', '3210987654', 'resume_rohan.pdf'),
(208, 'Anjali', 'Mishra', 'anjali.mishra@example.com', '2109876543', 'resume_anjali.pdf'),
(209, 'Vikram', 'Chopra', 'vikram.chopra@example.com', '1098765432', 'resume_vikram.pdf'),
(210, 'Sneha', 'Rao', 'sneha.rao@example.com', '9876543201', 'resume_sneha.pdf');

INSERT INTO Applications (ApplicationID, JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES
(301, 101, 201, '2025-04-02', 'I am excited to apply for this role.'),
(302, 102, 202, '2025-04-03', 'My skills match the job requirements.'),
(303, 103, 203, '2025-04-04', 'Looking forward to working with your team.'),
(304, 104, 204, '2025-04-05', 'Please consider my application.'),
(305, 105, 205, '2025-04-06', 'I have the experience you are seeking.'),
(306, 106, 206, '2025-04-07', 'Creative and driven, ready to contribute.'),
(307, 107, 207, '2025-04-08', 'Cloud services are my forte.'),
(308, 108, 208, '2025-04-09', 'Passionate about technical writing.'),
(309, 109, 209, '2025-04-10', 'Experienced in business analysis.'),
(310, 110, 210, '2025-04-11', 'Testing is my strength and passion.');

select*from companies;
select*from applicants;
select*from jobs;
select*from applications;