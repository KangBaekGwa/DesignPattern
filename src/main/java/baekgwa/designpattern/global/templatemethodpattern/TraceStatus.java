package baekgwa.designpattern.global.templatemethodpattern;

public class TraceStatus {
    private final String threadId;
    private final Long startTime;
    private final String methodName;

    public TraceStatus(String threadId, Long startTimeMs, String methodName) {
        this.threadId = threadId;
        this.startTime = startTimeMs;
        this.methodName = methodName;
    }

    public String getThreadId() {
        return threadId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public String getMethodName() {
        return methodName;
    }
}
