package edu.disease.asgn2;
import java.util.UUID;

/**
 * This interface provides methods for managing diseases, patients, and their interactions.
 */
public interface DiseaseControlManager {

    /**
     * Adds a new disease to the management system.
     *
     * @param name      The name of the disease.
     * @param infection Indicates whether the disease is infectious.
     * @return The created Disease object representing the added disease.
     */
    Disease2 addDisease(String name, boolean infection);

    /**
     * Retrieves a disease by its unique identifier.
     *
     * @param diseaseId The UUID of the disease to retrieve.
     * @return The Disease object associated with the given UUID, or null if not found.
     */
    Disease2 getDisease(UUID diseaseId);

    /**
     * Adds a new patient to the management system.
     *
     * @param firstName    The first name of the patient.
     * @param lastName     The last name of the patient.
     * @param maxDisease   The maximum number of diseases the patient can have.
     * @param maxExposures The maximum number of exposures the patient can have.
     * @return The created Patient object representing the added patient.
     */
    Patient addPatient(String firstName, String lastName, int maxDisease, int maxExposures);

    /**
     * Retrieves a patient by their unique identifier.
     *
     * @param patientId The UUID of the patient to retrieve.
     * @return The Patient object associated with the given UUID, or null if not found.
     */
    Patient getPatient(UUID patientId);

    /**
     * Associates a disease with a patient.
     *
     * @param patientId The UUID of the patient.
     * @param diseaseId The UUID of the disease to associate.
     */
    void addDiseaseToPatient(UUID patientId, UUID diseaseId);

    /**
     * Associates an exposure with a patient.
     *
     * @param patientId The UUID of the patient.
     * @param exposure  The Exposure object representing the exposure to associate.
     */
    void addExposureToPatient(UUID patientId, Exposure exposure);
}