package me.choicore.samples.monorepo.common;

import me.choicore.samples.monorepo.test.context.TestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TestApplication.class})
public class ApplicationTests {
    @Test
    void contextLoads() {
    }
}
