package baekgwa.designpattern.web.v0;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestServiceV0 {

    private final TestRepositoryV0 testRepository;

    void saveName(String name) {
        long startTime = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        testRepository.save(name); //실제 필요 로직

        long endTime = System.currentTimeMillis();
        log.info("[{}][{}] : Running Time : {}", uuid, methodName, endTime - startTime);
    }
}
