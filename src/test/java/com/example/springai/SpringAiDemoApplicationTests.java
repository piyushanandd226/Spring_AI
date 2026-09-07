package com.example.springai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = "spring.ai.openai.api-key=test-key")
class SpringAiDemoApplicationTests {

    @Test
    void contextLoads() {
        assertNotNull(SpringAiDemoApplication.class);
    }
}
