package acceptance.bridge;

// why an action failed. the tests check the reason and not the exact text of the message
public enum FailureReason {
    MISSING_DETAILS,
    INVALID_INPUT,
    TOO_MANY_STUDENTS,
    STUDENT_ALREADY_REGISTERED,
    ADVISOR_DID_NOT_AGREE
}
