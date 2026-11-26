package acceptance.bridge;

import java.util.List;

// temporary implementation (stub / proxy bridge).
// while there is no real system, it returns answers that were set in advance
// for the scenarios we chose. when a real bridge is set, every call goes to it.
public class ProxyBridge implements ProjectSystemBridge {

    private ProjectSystemBridge real = null;

    public void setRealBridge(ProjectSystemBridge real) {
        this.real = real;
    }

    @Override
    public void addApprovedProject(String projectId, String projectName) {
        if (real != null) real.addApprovedProject(projectId, projectName);
    }

    @Override
    public void addAdvisor(String advisorName, int projectsAlreadyAdvising) {
        if (real != null) real.addAdvisor(advisorName, projectsAlreadyAdvising);
    }

    @Override
    public void advisorMarksProject(String advisorName, String projectId) {
        if (real != null) real.advisorMarksProject(advisorName, projectId);
    }

    @Override
    public void addThirdYearStudent(String studentId) {
        if (real != null) real.addThirdYearStudent(studentId);
    }

    @Override
    public Result addProject(String projectName, String description, String hours,
                             String firstName, String lastName, String email, String phone,
                             String organization) {
        if (real != null) {
            return real.addProject(projectName, description, hours,
                    firstName, lastName, email, phone, organization);
        }
        // fixed answers: scenario with an empty field -> fails, otherwise -> a fixed code
        if (projectName == null || projectName.isBlank()) {
            return Result.fail(FailureReason.MISSING_DETAILS);
        }
        return Result.ok("PRJ-0001");
    }

    @Override
    public ProjectStatus getProjectStatus(String projectCode) {
        if (real != null) return real.getProjectStatus(projectCode);
        return ProjectStatus.IN_REVIEW;
    }

    @Override
    public Result registerToProject(String projectId, List<String> studentIds, String advisorName) {
        if (real != null) return real.registerToProject(projectId, studentIds, advisorName);
        // fixed answers: 3 students -> fails, otherwise -> a fixed access code
        if (studentIds.size() > 2) {
            return Result.fail(FailureReason.TOO_MANY_STUDENTS);
        }
        return Result.ok("ACCESS-0001");
    }

    @Override
    public boolean isStudentRegisteredTo(String studentId, String projectId) {
        if (real != null) return real.isStudentRegisteredTo(studentId, projectId);
        return false;
    }
}
