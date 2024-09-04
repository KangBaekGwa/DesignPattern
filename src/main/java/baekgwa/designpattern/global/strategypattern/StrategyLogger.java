package baekgwa.designpattern.global.strategypattern;

import baekgwa.designpattern.global.templatemethodpattern.Logger;
import baekgwa.designpattern.global.templatemethodpattern.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class StrategyLogger {

    private final Strategy strategy; //사용할 전략
    private final Logger logger;

    /**
     * 전략 전후로 사용할 변하지 않을 템플릿 코드
     * @param methodName
     */
    public void execute(String methodName) {
        TraceStatus status = logger.start(methodName);
        strategy.call();
        logger.end(status);
    }
}
