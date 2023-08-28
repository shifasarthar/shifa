package edu.disease.asn1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class ExposureTest1 {
    private Exposure exposure;

    

    @Test
    void gettersAndSetters() {
        // Test getter and setter for datetime
        LocalDateTime newDateTime = LocalDateTime.of(2023, 8, 1, 10, 0);
        exposure.setDatetime(newDateTime);
        assertEquals(newDateTime, exposure.getDateTime());

        // Test getter and setter for exposureType
        String newExposureType = "I";
        exposure.setExposureType(newExposureType);
        assertEquals(newExposureType, exposure.getExposureType());
    }
    
    @BeforeEach
    void setUp() {
        UUID patientId = UUID.randomUUID();
        LocalDateTime dateTime = LocalDateTime.now();
        exposure = new Exposure(patientId, dateTime, "D");
    }

    @Test
    void exposureTypeValidation() {
        // Test valid exposure type "D"
        exposure.setExposureType("D");
        assertEquals("D", exposure.getExposureType());

        // Test valid exposure type "I"
        exposure.setExposureType("I");
        assertEquals("I", exposure.getExposureType());

        // Test invalid exposure type
        assertThrows(IllegalArgumentException.class, () -> exposure.setExposureType("X"));
    }

    @Test
    void hashCodeAndEquals() {
        UUID patientId = exposure.getPatientId();
        LocalDateTime dateTime = exposure.getDateTime();
        Exposure sameExposure = new Exposure(patientId, dateTime, "D");

        // Check if two instances with the same patientId and dateTime are equal
        assertTrue(exposure.equals(sameExposure));
        assertEquals(exposure.hashCode(), sameExposure.hashCode());

        // Create a different exposure with different patientId and dateTime
        UUID differentPatientId = UUID.randomUUID();
        LocalDateTime differentDateTime = LocalDateTime.now();
        Exposure differentExposure = new Exposure(differentPatientId, differentDateTime, "I");

        // Check if the instances with different patientId and dateTime are not equal
        assertFalse(exposure.equals(differentExposure));
        assertNotEquals(exposure.hashCode(), differentExposure.hashCode());
    }

    @Test
    void toStringTest() {
        String expected = "Exposure{" +
                "patientId=" + exposure.getPatientId() +
                ", datetime=" + exposure.getDateTime() +
                ", exposureType='" + exposure.getExposureType() + '\'' +
                '}';

        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + exposure.toString());

        assertEquals(expected, exposure.toString());
    }

}
