package edu.disease;

import java.util.UUID;

/**
 * Represents a disease.
 */
public class Disease {
    private UUID diseaseId;
    private String name;

    // Getter and setter methods for properties

    @Override
    public int hashCode() {
        return diseaseId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Disease disease = (Disease) obj;
        return diseaseId.equals(disease.diseaseId);
    }

    @Override
    public String toString() {
        return "Disease{" +
                "diseaseId=" + diseaseId +
                ", name='" + name + '\'' +
                '}';
    }

	public void setDiseaseId(UUID randomUUID) {
		// TODO Auto-generated method stub
		
	}

	void setName(String string) {
		// TODO Auto-generated method stub
		
	}
}
