package baekgwa.designpattern.web.v1;

import baekgwa.designpattern.global.ThreadLogger;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class TestRepositoryV1 {

    private ThreadLocal<String> nameSpace = new ThreadLocal<>();

    void save(String name, ThreadLogger threadLogger){
        threadLogger.start();
        if(name.equals("null")){
            throw new IllegalStateException("\"null\"은 이름으로 받을 수 없습니다.");
        }
        nameSpace.set(name);

        sleep(1000); //실제 필요 로직
        threadLogger.end(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            log.info("Interrupt 발생");
            e.printStackTrace();
        }
    }
}
