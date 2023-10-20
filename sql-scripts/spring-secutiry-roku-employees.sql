USE roku_directory;


DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `employee`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  UNIQUE KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
--
-- Default passwords here are: fun123
--

INSERT INTO `users`
VALUES
('mike','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('harry','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('anna','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);

--
-- Table structure for table `employees`
--
CREATE TABLE `employee` (
	`id` int NOT NULL AUTO_INCREMENT,
    `firstName` VARCHAR(50) NULL DEFAULT NULL,
    `lastName` VARCHAR(50) NULL DEFAULT NULL,
    `email` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `employee`
--
INSERT INTO `employee`
VALUES
	(1,'Mike','Seinfeld','mike@roku.com'),
	(2,'Aarry','David','harry@ruku.com'),
	(3,'Anna','Stern','anna@roku.com');



--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
('mike','ROLE_DOCTOR'),
('mike','ROLE_EMPLOYEE'),
('harry','ROLE_NURSE'),
('harry','ROLE_EMPLOYEE'),
('anna','ROLE_ADMIN'),
('anna','ROLE_EMPLOYEE');



DROP TABLE IF EXISTS `medical_history`;
DROP TABLE IF EXISTS `medication_history`;
DROP TABLE IF EXISTS `patients`;
DROP TABLE IF EXISTS `medications`;




CREATE TABLE `patients`(
	PatientId INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL
);

CREATE TABLE `medical_history` (
	MedicalHistoryId INT PRIMARY KEY AUTO_INCREMENT,
    PatientId INT NOT NULL,
    Allergies TEXT,
    MedicalConditions TEXT,
    SurgicalHistory TEXT,
    MedicationHistroy TEXT,

    FOREIGN KEY (PatientId) REFERENCES patients(PatientId)
);

CREATE TABLE `medications`(
	MedicationId INT PRIMARY KEY AUTO_INCREMENT,
    MedicationName VARCHAR(100) NOT NULL
);

CREATE TABLE `medication_history`(
	MedicationHistoryID INT PRIMARY KEY AUTO_INCREMENT,
    PatientId INT NOT NULL,
    MedicationId INT NOT NULL,
    PrescriptionDate DATE NOT NULL,
    Dosage VARCHAR(50),
    ReasonForPres TEXT,
    PrescribingDoctor INT NOT NULL,
    Response TEXT,

    FOREIGN KEY (PatientId) REFERENCES patients(PatientId),
    FOREIGN KEY (MedicationId) REFERENCES medications (MedicationId),
    FOREIGN KEY (PrescribingDoctor) REFERENCES employee (id)
);