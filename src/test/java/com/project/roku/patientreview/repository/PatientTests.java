package com.project.roku.patientreview.repository;

import com.project.roku.dao.PatientRepository;
import com.project.roku.entity.Patient;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PatientTests {

    // bring in the patient repo
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void PatientRepository_SaveAll_ReturnsPatients(){

        // Arrange
        Patient patient = Patient.builder()
                .patientId(10)
                .patientFirstName("Harry")
                .patientLastName("Potter")
                .patientAddress("Godrics Hollow")
                .patientEmail("harry@roku.com")
                .build();
        //Act
        Patient savedPatient = patientRepository.save(patient);
        //Assert
        Assertions.assertThat(savedPatient).isNotNull();
        Assertions.assertThat(savedPatient.getPatientId()).isGreaterThan(0);
    }
}
