package web.model.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
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
    private String userid;

    private String password;

    private java.sql.Timestamp createddate;

    @Column(nullable = true)
    private java.sql.Timestamp updateddate;

    private boolean islock;

    @Column(nullable = true)
    private int retry;

    @Column(nullable = true)
    private java.sql.Timestamp lastlogindate;

}
