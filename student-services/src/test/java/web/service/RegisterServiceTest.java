package web.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterServiceTest {
    private RegisterService registerService;

    @BeforeEach
    public void setup() {
        registerService = new RegisterService();
    }

    @Test
    void testDeleteAccount() {

    }

    @Test
    void testHelloWorld() {
        String helloWorld = registerService.HelloWorld();
        Assertions.assertThat(helloWorld).isNotNull();
        Assertions.assertThat(helloWorld).isEqualTo("Hello World!");

    }

    @Test
    void testRegistration() {

    }
}
