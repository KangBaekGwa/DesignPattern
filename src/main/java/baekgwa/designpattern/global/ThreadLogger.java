package baekgwa.designpattern.global;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLogger {

    public ThreadLocal<String> threadId = new ThreadLocal<>();
    public ThreadLocal<Long> startTime = new ThreadLocal<>();

    public ThreadLogger() {
        threadId.set(UUID.randomUUID().toString().substring(0, 8));
    }

    public void start() {
        startTime.set(System.currentTimeMillis());
    }

    public void end(String methodName) {
        long endTime = System.currentTimeMillis();
        log.info("[{}][{}] : Running Time : {}", threadId.get(), methodName,
                endTime - startTime.get());
    }
}
