package baekgwa.designpattern.global.templatemethodpattern;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ThreadLocalLogger implements Logger{

    private ThreadLocal<String> threadId = new ThreadLocal<>();

    @Override
    public TraceStatus start(String methodName) {
        if(threadId.get() == null){
            threadId.set(UUID.randomUUID().toString().substring(0, 8));
        }

        Long startTime = System.currentTimeMillis();
        return new TraceStatus(threadId.get(), startTime, methodName);
    }

    @Override
    public void end(TraceStatus traceStatus) {
        Long endTime = System.currentTimeMillis();
        log.info("[{}][{}] : Running Time : {}", threadId.get(), traceStatus.getMethodName(),
                endTime - traceStatus.getStartTime());
    }
}
