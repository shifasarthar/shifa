package edu.disease;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents an exposure event for a patient.
 */
public class Exposure {
    private UUID patientId;
    private LocalDateTime dateTime;
    private String exposureType;

    /**
     * Constructs an Exposure object with the given patient ID.
     *
     * @param patientId The UUID of the patient.
     */
    public Exposure(UUID patientId) {
        this.patientId = patientId;
    }

    /**
     * Gets the patient ID.
     *
     * @return The UUID of the patient.
     */
    public UUID getPatientId() {
        return patientId;
    }

    /**
     * Gets the date and time of the exposure.
     *
     * @return The date and time of the exposure.
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time of the exposure.
     *
     * @param dateTime The date and time of the exposure.
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Gets the exposure type.
     *
     * @return The exposure type ("D" for direct, "I" for indirect).
     */
    public String getExposureType() {
        return exposureType;
    }

    /**
     * Sets the exposure type. Only accepts "D" or "I".
     *
     * @param exposureType The exposure type to set ("D" for direct, "I" for indirect).
     * @throws IllegalArgumentException If exposure type is not "D" or "I".
     */
    public void setExposureType(String exposureType) {
        if (!exposureType.equals("D") && !exposureType.equals("I")) {
            throw new IllegalArgumentException("Exposure type must be 'D' or 'I'.");
        }
        this.exposureType = exposureType;
    }

    @Override
    public int hashCode() {
        return patientId.hashCode() + dateTime.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Exposure exposure = (Exposure) obj;
        return patientId.equals(exposure.patientId) && dateTime.equals(exposure.dateTime);
    }

    @Override
    public String toString() {
        return "Exposure{" +
                "patientId=" + patientId +
                ", dateTime=" + dateTime +
                ", exposureType='" + exposureType + '\'' +
                '}';
    }
}
