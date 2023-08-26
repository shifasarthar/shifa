package edu.disease;

import java.util.UUID;

/**
 * Represents a patient with exposure and disease information.
 */
public class Patient {
    private UUID patientId;
    private String firstName;
    private String lastName;
    private Exposure[] exposures;
    private UUID[] diseaseIds;

    /**
     * Constructs a Patient object with given maximum disease and exposure capacities.
     *
     * @param maxDiseases   Maximum number of diseases.
     * @param maxExposures  Maximum number of exposures.
     * @throws IllegalArgumentException If maxDiseases or maxExposures are invalid.
     */
    public Patient(int maxDiseases, int maxExposures) {
        if (maxDiseases <= 0 || maxExposures <= 0) {
            throw new IllegalArgumentException("Max diseases and exposures must be greater than 0.");
        }
        diseaseIds = new UUID[maxDiseases];
        exposures = new Exposure[maxExposures];
    }

    /**
     * Adds a disease ID to the patient's diseases array.
     *
     * @param diseaseId The UUID of the disease to add.
     * @throws IndexOutOfBoundsException If the diseases array is full.
     */
    public void addDiseaseId(UUID diseaseId) {
        // Implement code to add diseaseId to the array
    }

    /**
     * Adds an exposure to the patient's exposures array.
     *
     * @param exposure The exposure to add.
     * @throws IndexOutOfBoundsException If the exposures array is full.
     */
    public void addExposure(Exposure exposure) {
        // Implement code to add exposure to the array
    }

    // Getter and setter methods for remaining properties

    @Override
    public int hashCode() {
        return patientId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Patient patient = (Patient) obj;
        return patientId.equals(patient.patientId);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                // Include other properties here
                '}';
    }
}
