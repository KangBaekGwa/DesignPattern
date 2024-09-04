package baekgwa.designpattern.web.v1;

import baekgwa.designpattern.global.ThreadLogger;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestServiceV1 {

    private final TestRepositoryV1 testRepository;

    void saveName(String name, ThreadLogger threadLogger) {
        threadLogger.start();
        testRepository.save(name, threadLogger); //실제 필요 로직
        threadLogger.end(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
