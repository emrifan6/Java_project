package com.mahardhika.webapplication.config;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class userData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 16)
    private String userName;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, unique = true, length = 16)
    private String nomorKartu;
    @Column(nullable = false, unique = true, length = 12)
    private String nomorHp;
    @Column
    @CreationTimestamp
    private Date createdDate;
    @Column
    @UpdateTimestamp
    private Date modifiedDate;
    @Column(nullable = false)
    private Boolean statusUserId;
    @OneToOne(mappedBy = "users")
    private passData passwords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomorKartu() {
        return nomorKartu;
    }

    public void setNomorKartu(String nomorKartu) {
        this.nomorKartu = nomorKartu;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getStatusUserId() {
        return statusUserId;
    }

    public void setStatusUserId(Boolean statusUserId) {
        this.statusUserId = statusUserId;
    }

    public passData getPasswords() {
        return passwords;
    }

    public void setPasswords(passData passwords) {
        this.passwords = passwords;
    }

    @Override
    public String toString() {
        return "userData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", nomorKartu='" + nomorKartu + '\'' +
                ", nomorHp='" + nomorHp + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", statusUserId=" + statusUserId +
                ", passwords=" + passwords +
                '}';
    }
}
