package baekgwa.designpattern.web.v3;

import baekgwa.designpattern.global.strategypattern.StrategyLogger;
import baekgwa.designpattern.global.templatemethodpattern.AbstractThreadLogger;
import baekgwa.designpattern.global.templatemethodpattern.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3")
@RequiredArgsConstructor
@Slf4j
public class TestControllerV3 {

    private final TestServiceV3 testService;
    private final Logger logger;

    @GetMapping("/save")
    public String saveName(
            @RequestParam("name") String name
    ) {
        StrategyLogger strategyLogger = new StrategyLogger(() -> {
            testService.saveName(name); //실제 필요 로직
        }, logger);
        strategyLogger.execute(Thread.currentThread().getStackTrace()[1].getMethodName());
        return "ok";
    }
}
