package edu.disease;

import java.util.Arrays;
import java.util.UUID;

public class TestExposureAndPatient {
    public static void main(String[] args) {
        // Create a UUID for a patient
        UUID patientId = UUID.randomUUID();

        // Create an Exposure instance
        Exposure exposure = new Exposure(patientId);
        exposure.setExposureType("D");

        // Create a Patient instance
        Patient patient = new Patient(patientId);
        patient.addDiseaseId(UUID.randomUUID());
        patient.addDiseaseId(UUID.randomUUID());

        // Add the exposure to the patient
        patient.addExposure(exposure);

        // Print patient information
        System.out.println("Patient ID: " + patient.getPatientId());
        System.out.println("Disease IDs: " + Arrays.toString(patient.getDiseaseIds()));
        System.out.println("Exposures: " + Arrays.toString(patient.getExposures()));
    }
}
