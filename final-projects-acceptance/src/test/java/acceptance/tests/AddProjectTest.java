package acceptance.tests;

import acceptance.bridge.FailureReason;
import acceptance.bridge.ProjectStatus;
import acceptance.bridge.Result;
import org.junit.Test;

import static org.junit.Assert.*;

// user story 1 - add project
public class AddProjectTest extends AcceptanceTestBase {

    // Test 1 (happy): add project with all details -> get code, status is in review
    @Test
    public void addProjectWithAllDetails() {
        Result result = bridge.addProject(
                "אפליקציה לניהול חניה",
                "אפליקציה שמראה חניות פנויות בקמפוס",
                "300",
                "דנה", "כהן", "dana@gmail.com", "050-1234567",
                "מכללת ספיר");

        assertTrue(result.isSuccess());
        assertNotNull(result.getValue());
        assertEquals(ProjectStatus.IN_REVIEW, bridge.getProjectStatus(result.getValue()));
    }

    // Test 2 (sad): add project without a name -> not saved, missing details
    @Test
    public void addProjectWithoutName() {
        Result result = bridge.addProject(
                "",
                "אפליקציה שמראה חניות פנויות בקמפוס",
                "300",
                "דנה", "כהן", "dana@gmail.com", "050-1234567",
                "מכללת ספיר");

        assertFalse(result.isSuccess());
        assertNull(result.getValue());
        assertEquals(FailureReason.MISSING_DETAILS, result.getReason());
    }
}
