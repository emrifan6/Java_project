package web.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegisterServiceTest {
    // private RegisterService registerService;

    // @BeforeEach
    // public void setup() {
    // registerService = new RegisterService();
    // }

    // @Test
    // void testDeleteAccount() {

    // }

    // @Test
    // void testHelloWorld() {
    // String helloWorld = registerService.HelloWorld();
    // Assertions.assertThat(helloWorld).isNotNull();
    // Assertions.assertThat(helloWorld).isEqualTo("Hello World!");

    // }

    // @Test
    // void testRegistration() {
    // /*
    // * Register Validate Code
    // * 0 = fail
    // * 1 = user_id already in users table
    // * 2 = succes registration
    // */
    // int registration = registerService.Registration("test", "test@email.com",
    // "password_test", "0000000000",
    // "0810000000");
    // Assertions.assertThat(registration).isEqualTo(2);
    // int registration_same = registerService.Registration("test",
    // "test@email.com", "password_test", "0000000000",
    // "0810000000");
    // Assertions.assertThat(registration_same).isEqualTo(1);
    // }
}
