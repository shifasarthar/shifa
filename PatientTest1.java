package edu.disease.asn1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest1 {
    private Patient patient;
    

    @BeforeEach
    void setUp(){
    	
    		UUID patientId = UUID.randomUUID();
        patient = new Patient(patientId, "John", "Doe", 5, 3);
    	
    }
    
    @Test
    void constructorWithInvalidArguments() {
        UUID patientId = UUID.randomUUID();
        // Test constructor with invalid values for maxExposures and maxDiseases
        assertThrows(IllegalArgumentException.class, () -> new Patient(patientId, "John", "Doe", 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Patient(patientId, "Jane", "Doe", -1, 5));
        assertThrows(IllegalArgumentException.class, () -> new Patient(patientId, "Alice", "Smith", 10, -1));
    }
    
    @Test
    void gettersAndSetters() {
        // Test getter and setter for firstName
        String newFirstName = "Jane";
        patient.setFirstName(newFirstName);
        assertEquals(newFirstName, patient.getFirstName());

        // Test getter and setter for lastName
        String newLastName = "Smith";
        patient.setLastName(newLastName);
        assertEquals(newLastName, patient.getLastName());

        // Test getter and setter for exposures
        Exposure[] newExposures = new Exposure[5];
        patient.setExposures(newExposures);
        assertArrayEquals(newExposures, patient.getExposures());

        // Test getter and setter for diseaseIds
        UUID[] newDiseaseIds = new UUID[3];
        patient.setDiseaselds(newDiseaseIds);
        assertArrayEquals(newDiseaseIds, patient.getdiseaselds());
    }
 
    @Test
    void addDiseaseId() {
        UUID diseaseId = UUID.randomUUID();
        assertDoesNotThrow(() -> patient.addDiseaseId(diseaseId));
    }

    @Test
    void addExposureId() {
        Exposure exposure = new Exposure(UUID.randomUUID(), null, "D");
        assertDoesNotThrow(() -> patient.addExposureId(exposure));
    }

    @Test
    void hashCodeAndEquals() {
        UUID patientId = patient.getPatientId();
        Patient samePatient = new Patient(patientId, "John", "Doe", 5, 3);

        // Check if two instances with the same patientId are equal
        assertTrue(patient.equals(samePatient));
        assertEquals(patient.hashCode(), samePatient.hashCode());

        // Create a different patient with different patientId
        UUID differentPatientId = UUID.randomUUID();
        Patient differentPatient = new Patient(differentPatientId, "Jane", "Smith", 5, 3);

        // Check if the instances with different patientId are not equal
        assertFalse(patient.equals(differentPatient));
        assertNotEquals(patient.hashCode(), differentPatient.hashCode());
    }

    @Test
    void toStringTest() {
        String expected = "Patient{" +
                "patientId=" + patient.getPatientId() +
                ", FirstName=John" +
                ", LastName=Doe" +
                ", exposures=[null, null, null, null, null]" +
                ", diseaseIds=[null, null, null]" +
                '}';
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + patient.toString());

        assertEquals(expected, patient.toString());
    }

}