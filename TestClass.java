package edu.disease;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.UUID;
public class TestClass {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for Exposure
        System.out.println("Enter patient ID for Exposure: ");
        UUID exposurePatientId = UUID.fromString(scanner.nextLine());

        Exposure exposure = new Exposure(exposurePatientId);

        System.out.println("Enter date and time (yyyy-MM-dd HH:mm:ss) for Exposure: ");
        String exposureDateTimeStr = scanner.nextLine();
        LocalDateTime exposureDateTime = LocalDateTime.parse(exposureDateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        exposure.setDateTime(exposureDateTime);

        System.out.println("Enter exposure type (D for direct, I for indirect): ");
        String exposureType = scanner.nextLine();
        exposure.setExposureType(exposureType);

        System.out.println("Exposure: " + exposure);

        // Taking user input for Patient
        System.out.println("Enter maximum number of diseases: ");
        int maxDiseases = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter maximum number of exposures: ");
        int maxExposures = Integer.parseInt(scanner.nextLine());

        Patient patient = new Patient(maxDiseases, maxExposures);

        // Taking user input for Disease IDs (just one for demonstration)
        System.out.println("Enter disease ID for Patient: ");
        UUID diseaseId = UUID.fromString(scanner.nextLine());
        patient.addDiseaseId(diseaseId);

        // Taking user input for Disease
        Disease disease = new Disease();

        System.out.println("Enter disease name: ");
        String diseaseName = scanner.nextLine();
        disease.setName(diseaseName);

        System.out.println("Disease: " + disease);

        scanner.close();
    }
}

