package me.choicore.samples.monorepo.core;

import me.choicore.samples.test.context.TestApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TestApplication.class})
public class ApplicationTests {
    @Test
    void contextLoads() {
    }
}
