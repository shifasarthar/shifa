package edu.disease.asgn2;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a patient with properties such as patient ID, first name, last
 * name, exposures, and disease IDs. The class implements the Comparable
 * interface to enable sorting of Patient objects based on last name and then
 * first name, in a case-insensitive manner.
 */
public class Patient implements Comparable<Patient> {
	private UUID patientId;
	private String firstName;
	private String lastName;
	private Exposure[] exposures;
	private UUID[] diseaseIds;

	// Comparator for sorting by last name and then first name
	/**
	 * A comparator for sorting patients by last name and then first name. This
	 * comparator considers the last name first and then, in cases of equal last
	 * names, compares the first name. The sorting is case-insensitive.
	 */
	public static final Comparator<Patient> LAST_FIRST_NAME_COMPARATOR = Comparator
			.comparing((Patient p) -> p.lastName.toLowerCase()).thenComparing(p -> p.firstName.toLowerCase());
			
	// Implement the compareTo() method for sorting
	/**
	 * Compares this patient with another patient for the purpose of sorting. This
	 * method overrides the compareTo() method from the Comparable interface.
	 *
	 * @param other The other patient to compare against.
	 * @return A negative integer, zero, or a positive integer as this patient is
	 *         less than, equal to, or greater than the other patient in terms of
	 *         sorting order.
	 */
	
	//@Override
	public int compareTo(Patient other) {
		return LAST_FIRST_NAME_COMPARATOR.compare(this, other);
	}

	/**
	 * Constructs a Patient object with the provided parameters.
	 *
	 * @param patientId    The unique identifier of the patient.
	 * @param firstName    The first name of the patient.
	 * @param lastName     The last name of the patient.
	 * @param maxExposures The maximum capacity for the exposures array.
	 * @param maxDiseases  The maximum capacity for the disease IDs array.
	 * @throws IllegalArgumentException If maxExposures or maxDiseases is not
	 *                                  greater than zero.
	 */
	public Patient(UUID patientId, String firstName, String lastName, int maxExposures, int maxDiseases) {
		if (maxExposures <= 0 || maxDiseases <= 0) {
			throw new IllegalArgumentException("Max exposures and max diseases must be greater than zero.");
		}
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
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
		this.lastName = lastName;
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
		this.exposures = exposures;
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
		for (int i = 0; i < diseaseIds.length; i++) {
			if (diseaseIds[i] == null) {
				diseaseIds[i] = diseaseId;
				return;// Exit the loop after adding the diseaseIds
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
		for (int i = 0; i < exposures.length; i++) {
			if (exposures[i] == null) {
				exposures[i] = exposure;
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
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Patient patient = (Patient) obj;
		return Objects.equals(patientId, patient.patientId);
	}

	/**
	 * Returns a string representation of this object.
	 *
	 * @return A string representation including patient ID, first name, last name,
	 *         exposures, and disease IDs.
	 */
	@Override
	public String toString() {
		return "Patient{" + "patientId=" + patientId + ", FirstName='" + firstName + '\'' + ", LastName='" + lastName
				+ '\'' + ", exposures=" + Arrays.toString(exposures) + ", diseaseIds=" + Arrays.toString(diseaseIds)
				+ '}';
	}

	public static void main(String[] args) {
		// Creating some sample exposures
		Exposure exposure1 = new Exposure(/* ... */);
		Exposure exposure2 = new Exposure(/* ... */);
		Exposure exposure3 = new Exposure(/* ... */);

		// Creating some sample disease IDs
		UUID diseaseId1 = UUID.randomUUID();
		UUID diseaseId2 = UUID.randomUUID();
		UUID diseaseId3 = UUID.randomUUID();

		// Creating patient objects
		Patient patient1 = new Patient(UUID.randomUUID(), "Alex", "Johny", 5, 3);
		patient1.addExposureId(exposure1);
		patient1.addDiseaseId(diseaseId1);

		Patient patient2 = new Patient(UUID.randomUUID(), "Jacob", "Edward", 5, 3);
		patient2.addExposureId(exposure2);
		patient2.addDiseaseId(diseaseId2);

		Patient patient3 = new Patient(UUID.randomUUID(), "Hyder", "Bella", 5, 3);
		patient1.addExposureId(exposure3);
		patient1.addDiseaseId(diseaseId3);

		// Displaying patient information
		System.out.println("Patient 1: " + patient1);
		System.out.println("Patient 2: " + patient2);
		System.out.println("Patient 2: " + patient3);

		List<Patient> patients = Arrays.asList(patient1, patient2, patient3);
		Collections.sort(patients, Patient.LAST_FIRST_NAME_COMPARATOR);

	}
}