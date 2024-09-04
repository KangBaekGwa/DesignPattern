package baekgwa.designpattern.web.v2;

import baekgwa.designpattern.global.templatemethodpattern.AbstractThreadLogger;
import baekgwa.designpattern.global.templatemethodpattern.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestServiceV2 {

    private final TestRepositoryV2 testRepository;
    private final Logger logger;

    void saveName(String name) {

        AbstractThreadLogger threadLogger = new AbstractThreadLogger(logger) {
            @Override
            public void call() {
                testRepository.save(name); //실제 필요 로직
            }
        };
        threadLogger.execute(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
