package baekgwa.designpattern.global.templatemethodpattern;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractThreadLogger {

    private final Logger logger;

    public void execute(String methodName){
        TraceStatus status = logger.start(methodName);
        call();
        logger.end(status);
    }

    public abstract void call();
}
