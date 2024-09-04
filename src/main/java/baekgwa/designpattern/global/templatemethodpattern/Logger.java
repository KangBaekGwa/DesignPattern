package baekgwa.designpattern.global.templatemethodpattern;

public interface Logger {

    TraceStatus start(String methodName);

    void end(TraceStatus traceStatus);
}
