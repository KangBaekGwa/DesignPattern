package baekgwa.designpattern.web.v3;

import baekgwa.designpattern.global.strategypattern.StrategyLogger;
import baekgwa.designpattern.global.templatemethodpattern.AbstractThreadLogger;
import baekgwa.designpattern.global.templatemethodpattern.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestServiceV3 {

    private final TestRepositoryV3 testRepository;
    private final Logger logger;

    void saveName(String name) {
        StrategyLogger strategyLogger = new StrategyLogger(() -> {
            testRepository.save(name); //실제 필요 로직
        }, logger);
        strategyLogger.execute(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
