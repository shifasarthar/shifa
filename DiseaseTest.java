package edu.disease.asgn2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

public class DiseaseTest {
    private UUID diseaseId;
    private String name;

    @BeforeEach
    void setUp() {
        diseaseId = UUID.randomUUID();
        name = "Test Disease";
    } 

    @Test
    void testInfectiousDisease() {
        InfectiousDisease infectiousDisease = new InfectiousDisease(diseaseId, name);
        String[] expectedExamples = {
            "Influenza",
            "COVID-19",
            "Measles",
            "Malaria"
        };

        assertArrayEquals(expectedExamples, infectiousDisease.getExamples());
        assertEquals(diseaseId, infectiousDisease.getDiseaseId());
        assertEquals(name, infectiousDisease.getName());
    }

    @Test
    void testNonInfectiousDisease() {
        NonInfectiousDisease nonInfectiousDisease = new NonInfectiousDisease(diseaseId, name);
        String[] expectedExamples = {
            "Diabetes",
            "Hypertension",
            "Cancer",
            "Alzheimer's disease"
        };

        assertArrayEquals(expectedExamples, nonInfectiousDisease.getExamples());
        assertEquals(diseaseId, nonInfectiousDisease.getDiseaseId());
        assertEquals(name, nonInfectiousDisease.getName());
    }
}