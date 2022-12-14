package web.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidationInputService {
    public boolean ValidateUserId(String user_id) {
        // check panjang user id
        System.out.println("**********************************");
        if (user_id.length() < 8 || user_id.length() > 32) {
            System.out.println("GAGAL, PANJANG USER ID TIDAK VALID");
            System.out.println(user_id + " = " + user_id.length());
            return false;
        }
        // check user id mengandung spasi
        for (int i = 0; i < user_id.length(); i++) {
            if (!Character.isDigit(user_id.charAt(i))
                    && !Character.isLetter(user_id.charAt(i))) {
                System.out.println("GAGAL, USER ID MENGANDUNG SPESIAL KARAKTER");
                System.out.println(user_id + " = " + user_id.charAt(i));
                return false;
            }
        }
        System.out.println("BERHASIL, USER ID VALID");
        System.out.println("USER ID = " + user_id + user_id.length());
        return true;
    }

    public boolean ValidatePassword(String password) {
        // check panjang PASSWORD
        System.out.println("**********************************");
        if (password.length() < 8 || password.length() > 32) {
            System.out.println("GAGAL, PANJANG PASSWORD TIDAK VALID");
            System.out.println(password + " = " + password.length());
            return false;
        }
        // check PASSWORD mengandung spasi
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isDigit(password.charAt(i))
                    && !Character.isLetter(password.charAt(i))
                    && Character.isWhitespace(password.charAt(i))) {
                System.out.println("GAGAL, PASSWORD MENGANDUNG SPESIAL KARAKTER");
                System.out.println(password + " = " + password.charAt(i));
                return false;
            }
        }
        System.out.println("BERHASIL, PASSWORD VALID");
        System.out.println("PASSWORD = " + password + " = " + password.length());
        return true;
    }

    public boolean ValidateEmail(String emailAddress) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern).matcher(emailAddress).matches();
    }

    public boolean ValidateNomorKartu(String nomor_kartu) {
        // check panjang nomor karu
        System.out.println("**********************************");
        if (!(nomor_kartu.length() == 13)) {
            System.out.println("GAGAL, PANJANG NOMOR KARTU TIDAK VALID");
            System.out.println(nomor_kartu + " = " + nomor_kartu.length());
            return false;
        }
        // check nomor kartu bukan angka
        for (int i = 0; i < nomor_kartu.length(); i++) {
            if (!Character.isDigit(nomor_kartu.charAt(i))) {
                System.out.println("GAGAL, NOMOR KARTU MENGANDUNG KARAKTER SELAIN ANGKA");
                System.out.println(nomor_kartu + " = " + nomor_kartu.charAt(i));
                return false;
            }
        }
        System.out.println("BERHASIL, NOMOR KARTU VALID");
        System.out.println("NOMOR KARTU = " + nomor_kartu + nomor_kartu.length());
        return true;
    }

    public boolean ValidateNomorHP(String nomor_hp) {
        // check panjang nomor hp
        System.out.println("**********************************");
        if (nomor_hp.length() < 8 || nomor_hp.length() > 13) {
            System.out.println("GAGAL, PANJANG NOMOR HP TIDAK VALID");
            System.out.println(nomor_hp + " = " + nomor_hp.length());
            return false;
        }
        // check nomor hp bukan angka
        for (int i = 0; i < nomor_hp.length(); i++) {
            if (!Character.isDigit(nomor_hp.charAt(i))) {
                System.out.println("GAGAL, NOMOR HP MENGANDUNG KARAKTER SELAIN ANGKA");
                System.out.println(nomor_hp + " = " + nomor_hp.charAt(i));
                return false;
            }
        }
        System.out.println("BERHASIL, NOMOR HP VALID");
        System.out.println("NOMOR HP = " + nomor_hp + nomor_hp.length());
        return true;
    }
}
