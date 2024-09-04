package baekgwa.designpattern.web.v0;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v0")
@RequiredArgsConstructor
@Slf4j
public class TestControllerV0 {

    private final TestServiceV0 testService;

    @GetMapping("/save")
    public String saveName(
            @RequestParam("name") String name
    ) {
        long startTime = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        testService.saveName(name); //실제 필요 로직

        long endTime = System.currentTimeMillis();
        log.info("[{}][{}] : Running Time : {}", uuid, methodName, endTime - startTime);
        return "ok";
    }
}
