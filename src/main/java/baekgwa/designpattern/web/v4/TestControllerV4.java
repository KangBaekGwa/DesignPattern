package baekgwa.designpattern.web.v4;

import baekgwa.designpattern.global.strategypattern.StrategyLogger;
import baekgwa.designpattern.global.strategypatternrefactoring.StrategyLoggerTemplate;
import baekgwa.designpattern.global.templatemethodpattern.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v4")
@RequiredArgsConstructor
@Slf4j
public class TestControllerV4 {

    private final TestServiceV4 testService;
    private final Logger logger;

    @GetMapping("/save")
    public String saveName(
            @RequestParam("name") String name
    ) {
        StrategyLoggerTemplate template = new StrategyLoggerTemplate(logger);
        template.execute(() -> {
            testService.saveName(name);
        }, Thread.currentThread().getStackTrace()[1].getMethodName());

        return "ok";
    }
}
