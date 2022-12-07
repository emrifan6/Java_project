package web.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {
        // in28minutes, dummy
        return userid.equalsIgnoreCase("user")
                && password.equalsIgnoreCase("user");
    }

}

// tabel user (Id, email, userId, nomorkartu, nomorHP, createddate,
// modifieddate, statusUserId)

// tabel password (userId, password, createddate, updateddate, isLock, retry,
// lastLogindate)

// pesan login gagal : login gagal, pastikan userId dan Password yang diinput
// benar
// kode misal.101=user tidak val
// kode userid benar dan password salah = 102
// kalau isLock = 1, pesan = userId anda terkunci, silahkan registrasi ulang
// islock = default = 0 (jika 1 berarti terkunci)
// setiap userId benar, update retry
// koneksi ke database menggunakan framework hibernet
// untuk error mesage dimasukkan kedalam file properties

//