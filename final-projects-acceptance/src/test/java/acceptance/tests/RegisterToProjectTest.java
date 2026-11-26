package acceptance.tests;

import acceptance.bridge.FailureReason;
import acceptance.bridge.Result;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

// user story 2 - register to project
public class RegisterToProjectTest extends AcceptanceTestBase {

    // state of the system before each test (from the table in part A, section D)
    @Before
    public void prepareSystem() {
        bridge.addApprovedProject("P-101", "אפליקציה לניהול חניה");
        bridge.addAdvisor("ד\"ר לוי", 2);
        bridge.advisorMarksProject("ד\"ר לוי", "P-101");
        bridge.addThirdYearStudent("123456782");
        bridge.addThirdYearStudent("234567891");
        bridge.addThirdYearStudent("345678917");
    }

    // Test 3 (happy): 2 students + advisor who agreed -> registration works, get access code
    @Test
    public void registerTwoStudentsWithAgreedAdvisor() {
        Result result = bridge.registerToProject(
                "P-101", List.of("123456782", "234567891"), "ד\"ר לוי");

        assertTrue(result.isSuccess());
        assertNotNull(result.getValue());
    }

    // Test 4 (sad): 3 students -> registration fails, too many students, nobody registered
    @Test
    public void registerThreeStudents() {
        Result result = bridge.registerToProject(
                "P-101", List.of("123456782", "234567891", "345678917"), "ד\"ר לוי");

        assertFalse(result.isSuccess());
        assertNull(result.getValue());
        assertEquals(FailureReason.TOO_MANY_STUDENTS, result.getReason());
        assertFalse(bridge.isStudentRegisteredTo("123456782", "P-101"));
    }
}
