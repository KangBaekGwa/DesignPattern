package baekgwa.designpattern.global.strategypatternrefactoring;

import baekgwa.designpattern.global.templatemethodpattern.Logger;
import baekgwa.designpattern.global.templatemethodpattern.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class StrategyLoggerTemplate {

    private final Logger logger;

    public void execute(Callback callback, String methodName) {
        TraceStatus status = logger.start(methodName);
        callback.call();
        logger.end(status);
    }
}
