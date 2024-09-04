package baekgwa.designpattern.web.v1;

import baekgwa.designpattern.global.ThreadLogger;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class TestControllerV1 {

    private final TestServiceV1 testService;

    @GetMapping("/save")
    public String saveName(
            @RequestParam("name") String name
    ) {
        ThreadLogger threadLogger = new ThreadLogger();
        threadLogger.start();

        testService.saveName(name, threadLogger); //실제 필요 로직

        threadLogger.end(Thread.currentThread().getStackTrace()[1].getMethodName());

        return "ok";
    }
}
