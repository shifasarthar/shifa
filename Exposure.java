package edu.disease;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Arrays;

public class Exposure {
    private UUID patientId;
    private String name;
    private int age;
    private String exposureType;

    public String getExposureType() {
        return exposureType;
    }

    public void setExposureType(String exposureType) {
        if (!exposureType.equals("D") && !exposureType.equals("I")) {
            throw new IllegalArgumentException("Invalid exposure type! Only 'D' for direct exposure or 'I' for indirect exposure are allowed.");
        }
        this.exposureType = exposureType;
    }

    public Exposure(UUID patientId) {
        this.patientId = patientId;
    }

    public Exposure(UUID patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Patient {
    private UUID patientId;
    private UUID[] diseaseIds;
    private Exposure[] exposures;

    public Patient(UUID patientId) {
        this.patientId = patientId;
        this.diseaseIds = new UUID[10];
        this.exposures = new Exposure[20];
    }

    public void addDiseaseId(UUID diseaseId) {
        int index = Arrays.asList(diseaseIds).indexOf(null);
        if (index == -1) {
            throw new IndexOutOfBoundsException("Disease IDs array is full.");
        }
        diseaseIds[index] = diseaseId;
    }

    public void addExposure(Exposure exposure) {
        int index = Arrays.asList(exposures).indexOf(null);
        if (index == -1) {
            throw new IndexOutOfBoundsException("Exposures array is full.");
        }
        exposures[index] = exposure;
    }

    public UUID getPatientId() {
        return patientId;
    }

	public long[] getDiseaseIds() {
		// TODO Auto-generated method stub
		return null;
	}

	public long[] getExposures() {
		// TODO Auto-generated method stub
		return null;
	}

    // Other getters, setters, equals, hashCode methods, etc.
}