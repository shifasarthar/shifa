package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID ;
import java.time.LocalDateTime;
/**
 * Represents an exposure event with properties such as patient ID, date and time,
 * and exposure type.
 */
public class Exposure {
	
		private UUID patientId;
		private LocalDateTime datetime;
		private String exposureType; 
		/**
	     * Constructs an Exposure object with the given patient ID.
	     *
	     * @param patientId The unique identifier of the patient associated with the exposure.
	     */
		public Exposure(UUID patientId,LocalDateTime datetime, String exposureType) {
			this.patientId = patientId; 
			this.datetime = datetime;
			this.exposureType = exposureType;
		}
		 public Exposure() {
			// no argument constructor 
		}
		/**
	     * Retrieves the patient ID associated with this exposure.
	     *
	     * @return The patient ID.
	     */
		public UUID getPatientId() {
			return patientId;
		}
		/**
	     * Retrieves the date and time of the exposure event.
	     *
	     * @return The date and time.
	     */
		public LocalDateTime getDateTime() {
			return datetime;
		}
		/**
	     * Sets the date and time of the exposure event.
	     *
	     * @param datetime The date and time of the exposure event.
	     */
		public void setDatetime(LocalDateTime datetime) {
			this.datetime = datetime;
		}
		 /**
	     * Retrieves the exposure type associated with this exposure.
	     *
	     * @return The exposure type.
	     */
		public String getExposureType() {
			return exposureType;
		}
		/**
	     * Sets the exposure type for this exposure event.
	     *
	     * @param exposureType The exposure type ("D" for direct, "I" for indirect).
	     * @throws IllegalArgumentException If the exposure type is not "D" or "I".
	     */
		public void setExposureType(String exposureType) {
			if(!exposureType.equals("D")&&!exposureType.equals("I")) {
				throw new  IllegalArgumentException("Exposure type must be 'D' for direct or 'I' for indirect.");
			}
			this.exposureType = exposureType;
		}
		//main method
		
		//
		/**
	     * Generates a hash code value for this object.
	     *
	     * @return The hash code value.
	     */
		@Override
		public int hashCode() {
			return Objects.hash(patientId,datetime);
		}
		
		/**
	     * Checks if this object is equal to another object.
	     *
	     * @param obj The object to compare with.
	     * @return {@code true} if the objects are equal, {@code false} otherwise.
	     */
	//@Override
		public boolean equals(Object obj) {
			Exposure exposure = (Exposure) obj;
			
			if(this==obj) {
				return (Boolean)true;
			}
			if(obj == null || getClass() != obj.getClass()) {
				return (Boolean)false;
			}
	        return Objects.equals(patientId, exposure.patientId) && Objects.equals(datetime, exposure.datetime);
	    
		}
		/**b
	     * Returns a string representation of this object.
	     *
	     * @return A string representation including patient ID, date and time, and exposure type.
	     */ 
		@Override
		public String toString() {
		    return "Exposure{" +
		            "patientId=" + patientId +
		            ", datetime=" + datetime +
		            ", exposureType='" + exposureType + '\'' +
		            '}';
		}
		
	}
