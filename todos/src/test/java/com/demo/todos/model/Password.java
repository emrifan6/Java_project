package com.demo.todos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passwords")
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User userid;

    private String password;

    private java.sql.Timestamp createddate;

    @Column(nullable = true)
    private java.sql.Timestamp updateddate;

    private boolean islock;

    @Column(nullable = true)
    private int retry;

    @Column(nullable = true)
    private java.sql.Timestamp lastlogindate;

    @Override
    public String toString() {
        return "userData{" +
                "userid=" + userid +
                ", password='" + password + '\'' +
                ", createddate='" + createddate + '\'' +
                ", updateddate='" + updateddate + '\'' +
                ", islock='" + islock + '\'' +
                ", retry=" + retry +
                ", lastlogindate=" + lastlogindate +
                '}';
    }
}
