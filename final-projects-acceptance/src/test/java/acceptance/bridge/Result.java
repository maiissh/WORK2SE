package acceptance.bridge;

// result of a business action: success + value (project code / access code) or failure + reason
public class Result {
    private final boolean success;
    private final String value;
    private final FailureReason reason;

    private Result(boolean success, String value, FailureReason reason) {
        this.success = success;
        this.value = value;
        this.reason = reason;
    }

    public static Result ok(String value) {
        return new Result(true, value, null);
    }

    public static Result fail(FailureReason reason) {
        return new Result(false, null, reason);
    }

    public boolean isSuccess() { return success; }
    public String getValue() { return value; }
    public FailureReason getReason() { return reason; }
}
