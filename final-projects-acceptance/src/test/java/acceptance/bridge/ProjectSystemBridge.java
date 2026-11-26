package acceptance.bridge;

import java.util.List;

// Interface Bridge: the business actions and the information the acceptance tests need.
// the tests only know this interface, not the real system.
public interface ProjectSystemBridge {

    // ---- preparing the state of the system before a test ----
    void addApprovedProject(String projectId, String projectName);
    void addAdvisor(String advisorName, int projectsAlreadyAdvising);
    void advisorMarksProject(String advisorName, String projectId);
    void addThirdYearStudent(String studentId);

    // ---- user story 1: add project ----
    Result addProject(String projectName, String description, String hours,
                      String firstName, String lastName, String email, String phone,
                      String organization);

    ProjectStatus getProjectStatus(String projectCode);

    // ---- user story 2: register to project ----
    Result registerToProject(String projectId, List<String> studentIds, String advisorName);

    boolean isStudentRegisteredTo(String studentId, String projectId);
}
