package baekgwa.designpattern.web.v4;

import baekgwa.designpattern.global.strategypattern.StrategyLogger;
import baekgwa.designpattern.global.strategypatternrefactoring.StrategyLoggerTemplate;
import baekgwa.designpattern.global.templatemethodpattern.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestServiceV4 {

    private final TestRepositoryV4 testRepository;
    private final Logger logger;

    void saveName(String name) {
        StrategyLoggerTemplate template = new StrategyLoggerTemplate(logger);
        template.execute(() -> {
            testRepository.save(name); //실제 필요 로직
        }, Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
