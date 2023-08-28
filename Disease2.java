package edu.disease.asgn2;
import java.util.Objects;
import java.util.UUID;
/**
 * Represents a disease with properties such as disease ID and name.
 */
public abstract class Disease2 { // Changed to an abstract class
	private UUID diseaseId;
	private String name;
	/**
     * Constructs a Disease object with the provided parameters.
     *
     * @param diseaseId The unique identifier of the disease.
     * @param name      The name of the disease.
     */
	public Disease2(UUID diseaseId,String name) { 
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
     * Retrieves the name of the disease.
     *
     * @return The name of the disease.
     */
	public String getName() {
		return name;
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
		Disease2 disease = (Disease2) obj;
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
	/**
     * Retrieves examples related to the disease.
     *
     * @return An array of String examples related to the disease.
     */
    public abstract String[] getExamples(); // Abstract method declaration

}
/**
 * Constructs an InfectiousDisease object with the provided parameters.
 *
 * @param diseaseId The unique identifier of the infectious disease.
 * @param name      The name of the infectious disease.
 */
	class InfectiousDisease extends Disease2{

	public InfectiousDisease(UUID diseaseId, String name) {
		super(diseaseId, name);
		
	}
	 /**
     * Override the getExamples() method to provide examples of infectious diseases.
     *
     * @return An array of four infectious disease names.
     */
	@Override
	public String[] getExamples() {
		// TODO Auto-generated method stub
		return new String[] {
				"Influenza",
				"COVID-19",
				"Measles",
				"Malaria"
		};
	}
	
}
	/**
	 * Represents a non-infectious disease with properties such as disease ID and name.
	 * This class is a subclass of the Disease class.
	 */
	class NonInfectiousDisease extends Disease2{
		/**
	     * Constructs a NonInfectiousDisease object with the provided parameters.
	     *
	     * @param diseaseId The unique identifier of the non-infectious disease.
	     * @param name      The name of the non-infectious disease.
	     */
		public NonInfectiousDisease(UUID diseaseId, String name) {
			super(diseaseId, name);
			
		}
		/**
	     * Override the getExamples() method to provide examples of non-infectious diseases.
	     *
	     * @return An array of four non-infectious disease names.
	     */
		@Override
		public String[] getExamples() {
			
			return new String[] {
					"Diabetes",
		            "Hypertension",
		            "Cancer",
		            "Alzheimer's disease"
		};
	}
}
