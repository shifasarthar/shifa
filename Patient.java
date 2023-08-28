package edu.disease.asn1;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
/**
 * Represents a patient with properties such as patient ID, first name, last name,
 * exposures, and disease IDs.
 */

public class Patient {
	private UUID patientId;
	private String firstName;
	private String lastName;
	private Exposure[] exposures;
	private UUID[] diseaseIds;
	 /**
     * Constructs a Patient object with the provided parameters.
     *
     * @param patientId    The unique identifier of the patient.
     * @param firstName    The first name of the patient.
     * @param lastName     The last name of the patient.
     * @param maxExposures The maximum capacity for the exposures array.
     * @param maxDiseases  The maximum capacity for the disease IDs array.
     * @throws IllegalArgumentException If maxExposures or maxDiseases is not greater than zero.
     */
	public Patient(UUID patientId, String firstName, String lastName, int maxExposures, int maxDiseases) {
		if (maxExposures <= 0 || maxDiseases <= 0) {
            throw new IllegalArgumentException("Max exposures and max diseases must be greater than zero.");
        }
		this.patientId = patientId; 
		this.firstName = firstName;
		this.lastName= lastName;
		this.exposures = new Exposure[maxExposures];
		this.diseaseIds = new UUID[maxDiseases]; 
	}
	 /**
     * Retrieves the patient ID of the patient.
     *
     * @return The patient ID.
     */
	public UUID getPatientId() {
		return patientId;
	}
	/**
     * Retrieves the first name of the patient.
     *
     * @return The first name.
     */
	public String getFirstName() {
		return firstName;
	}
	/**
     * Sets the first name of the patient.
     *
     * @param firstName The new first name.
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
     * Retrieves the last name of the patient.
     *
     * @return The last name.
     */
	public String getLastName() {
		return lastName;
	}
	/**
     * Sets the last name of the patient.
     *
     * @param lastName The new first name.
     */
	public void setLastName(String lastName) {
		this.lastName= lastName;
	}
	/**
     * Retrieves the array of exposures associated with the patient.
     *
     * @return The exposures array.
     */
	public Exposure[] getExposures() {
		return exposures;
	}
	/**
     * Sets the array of exposures associated with the patient.
     *
     * @param exposures The new exposures array.
     */
	public void setExposures(Exposure[] exposures) {
		this.exposures=exposures;
	}
	/**
     * Retrieves the array of disease IDs associated with the patient.
     *
     * @return The disease IDs array.
     */
	public UUID[] getdiseaselds() {
		return diseaseIds;
	}
	 /**
     * Sets the array of disease IDs associated with the patient.
     *
     * @param diseaseIds The new disease IDs array.
     */
	public void setDiseaselds(UUID[] diseaseIds) {
		this.diseaseIds = diseaseIds; 
	}
	/**
     * Adds a disease ID to the disease IDs array.
     *
     * @param diseaseId The UUID of the disease to add.
     * @throws IndexOutOfBoundsException If the disease IDs array is full.
     */
	public void addDiseaseId(UUID diseaseId) {
		for(int i=0; i < diseaseIds.length;i++) {
			if(diseaseIds[i]==null) {
				diseaseIds[i]=diseaseId;
				return;//Exit the loop after adding the diseaseIds
			}
		}
		throw new IndexOutOfBoundsException("Cannot add diseaseId. The diseaseIds array is full.");
	}
	 /**
     * Adds an exposure to the exposures array.
     *
     * @param exposure The Exposure object to add.
     * @throws IndexOutOfBoundsException If the exposures array is full.
     */
	public void addExposureId(Exposure exposure) {
		for(int i = 0; i<exposures.length;i++ ) {
			if(exposures[i]==null) {
				exposures[i]=exposure;
				return;
			}
		}
		throw new IndexOutOfBoundsException("Cannot add exposure. The exeposures array is full.");
	}
	 /**
     * Generates a hash code value for this object.
     *
     * @return The hash code value.
     * 
     */
	@Override
	public int hashCode() {
		return Objects.hash(patientId);
	}
	 /**
     * Checks if this object is equal to another object.
     *
     * @param obj The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
	@Override
	public boolean equals(Object obj) {
		Patient patient = (Patient) obj;
		if(this==obj) {
			return true; 
		}
		if (obj == null || getClass()!=obj.getClass()) {
			return false;
		} 
		return Objects.equals(patientId, patient.patientId);
	}
	
	/**
     * Returns a string representation of this object.
     *
     * @return A string representation including patient ID, first name, last name, exposures, and disease IDs.
     */
	@Override
	public String toString() {
	    return "Patient{" +
	            "patientId=" + patientId +
	            ", FirstName=" + firstName +
	            ", LastName=" + lastName  +
	            ", exposures=" + Arrays.toString(exposures) +
	            ", diseaseIds=" + Arrays.toString(diseaseIds) +
	            '}';
	}

}