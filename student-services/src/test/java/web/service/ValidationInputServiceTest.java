package web.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.val;

public class ValidationInputServiceTest {
    private ValidationInputService validationInputService;

    @BeforeEach
    public void setup() {
        validationInputService = new ValidationInputService();
    }

    @Test
    void testValidateUserId() {
        boolean check1 = validationInputService.ValidateUserId("rifan");
        boolean check2 = validationInputService.ValidateUserId("rifanrifanrifanrifanrifanrifanrifanrifanrifan");
        boolean check3 = validationInputService.ValidateUserId("rifan_45");
        boolean check4 = validationInputService.ValidateUserId("rifan44093");
        assertFalse(check1);
        assertFalse(check2);
        assertFalse(check3);
        assertTrue(check4);
    }

    @Test
    void testValidatePassword() {
        boolean check1 = validationInputService.ValidatePassword("pass");
        boolean check2 = validationInputService.ValidatePassword("passwordpasswordpasswordpasswordpassword");
        boolean check3 = validationInputService.ValidatePassword("pass word");
        boolean check4 = validationInputService.ValidatePassword("password");
        assertFalse(check1);
        assertFalse(check2);
        assertFalse(check3);
        assertTrue(check4);
    }

    @Test
    void testValidateEmail() {
        boolean check1 = validationInputService.ValidateEmail("rifan");
        boolean check2 = validationInputService.ValidateEmail("rifan.com");
        boolean check3 = validationInputService.ValidateEmail("rifan@gmail");
        boolean check4 = validationInputService.ValidateEmail("rifan@gmil.com");
        assertFalse(check1);
        assertFalse(check2);
        assertFalse(check3);
        assertTrue(check4);
    }

    @Test
    void testValidateNomorKartu() {
        boolean check1 = validationInputService.ValidateNomorKartu("1234567890");
        boolean check2 = validationInputService.ValidateNomorKartu("1234567890444444");
        boolean check3 = validationInputService.ValidateNomorKartu("1234567890ooo");
        boolean check4 = validationInputService.ValidateNomorKartu("1234567890123");
        assertFalse(check1);
        assertFalse(check2);
        assertFalse(check3);
        assertTrue(check4);
    }

    @Test
    void testValidateNomorHP() {
        boolean check1 = validationInputService.ValidateNomorHP("081225");
        boolean check2 = validationInputService.ValidateNomorHP("081225079410410");
        boolean check3 = validationInputService.ValidateNomorHP("081225o79410");
        boolean check4 = validationInputService.ValidateNomorHP("081225079410");
        assertFalse(check1);
        assertFalse(check2);
        assertFalse(check3);
        assertTrue(check4);
    }

}
