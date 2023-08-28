package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID;
/**
 * Represents a disease with properties such as disease ID and name.
 */
public class Disease {
	private UUID diseaseId;
	private String name;
	/**
     * Constructs a Disease object with the provided parameters.
     *
     * @param diseaseId The unique identifier of the disease.
     * @param name      The name of the disease.
     */
	public Disease(UUID diseaseId,String name) {
		this.diseaseId= diseaseId;
		this.name = name;
	}
	/**
     * Retrieves the disease ID of the disease.
     *
     * @return The disease ID.
     */
	public UUID getDiseaseId(){
		return diseaseId;
	}
	/**
     * Sets the disease ID of the disease.
     *
     * @param diseaseId The new disease ID.
     */
	public void setDiseseId(UUID diseaseId) {
		this.diseaseId=diseaseId;
	}
	/**
     * Retrieves the name of the disease.
     *
     * @return The name of the disease.
     */
	public String getName() {
		return name;
	}	
	 
	/**
     * Sets the name of the disease.
     *
     * @param name The new name of the disease.
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Generates a hash code value for this object.
     *
     * @return The hash code value.
     */
	@Override
	public int hashCode() {
		return Objects.hash(diseaseId);
	}
	 /**
     * Checks if this object is equal to another object.
     *
     * @param obj The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if (obj == null || getClass()!=obj.getClass()) {
			return false;
		}
		Disease disease = (Disease) obj;
		return Objects.equals(diseaseId, disease.diseaseId);
	}
	/**
     * Returns a string representation of this object.
     *
     * @return A string representation including disease ID and name.
     */
	@Override
	public String toString() {
        return "Disease{" +
                "diseaseId=" + diseaseId +
                ", name='" + name + '\'' +
                '}';
    }
}
