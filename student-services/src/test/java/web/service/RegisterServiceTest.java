package web.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegisterServiceTest {
    // private RegisterService registerService;

    // @Test
    // public void LengthTest() {
    // String user_id = "rifan 44093";
    // System.out.println("LengthTest");
    // System.out.println();
    // System.out.println();
    // System.out.println(user_id.length());
    // if (user_id.length() < 8 || user_id.length() > 13) {
    // System.out.println("PANJANG USER ID OK");
    // } else {
    // System.out.println("PANJANG USER ID GAGAL");
    // }
    // int count = 0;
    // for (int i = 0; i < user_id.length(); i++) {
    // if (user_id.charAt(i) == ' ') {
    // count++;
    // }
    // }
    // if (count > 0) {
    // System.out.println("USER ID MENGANDUNG SPASI");
    // }
    // System.out.println();
    // System.out.println();
    // }

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
