package web.model.entities;

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
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User iduser;

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
                "iduser=" + iduser +
                ", password='" + password + '\'' +
                ", createddate='" + createddate + '\'' +
                ", updateddate='" + updateddate + '\'' +
                ", islock='" + islock + '\'' +
                ", retry=" + retry +
                ", lastlogindate=" + lastlogindate +
                '}';
    }
}
