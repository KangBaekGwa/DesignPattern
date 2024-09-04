package baekgwa.designpattern.web.v0;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class TestRepositoryV0 {

    private ThreadLocal<String> nameSpace = new ThreadLocal<>();

    void save(String name){
        long startTime = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        if(name.equals("null")){
            throw new IllegalStateException("\"null\"은 이름으로 받을 수 없습니다.");
        }
        nameSpace.set(name);

        sleep(1000); //실제 필요 로직

        long endTime = System.currentTimeMillis();
        log.info("[{}][{}] : Running Time : {}", uuid, methodName, endTime - startTime);
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
