package baekgwa.designpattern.web.v3;

import baekgwa.designpattern.global.strategypattern.StrategyLogger;
import baekgwa.designpattern.global.templatemethodpattern.AbstractThreadLogger;
import baekgwa.designpattern.global.templatemethodpattern.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
public class TestRepositoryV3 {

    private ThreadLocal<String> nameSpace = new ThreadLocal<>();
    private final Logger logger;

    void save(String name) {

        StrategyLogger strategyLogger = new StrategyLogger(() -> {
            if (name.equals("null")) {
                throw new IllegalStateException("\"null\"은 이름으로 받을 수 없습니다.");
            }
            nameSpace.set(name);

            sleep(1000); //실제 필요 로직
        }, logger);

        strategyLogger.execute(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.info("Interrupt 발생");
            e.printStackTrace();
        }
    }
}
