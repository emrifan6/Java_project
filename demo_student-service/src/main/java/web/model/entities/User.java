package web.model.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(unique = true)
    private String userid;

    private String nomorkartu;

    private String nomorhp;

    private java.sql.Timestamp createddate;
    @Column(nullable = true)
    private java.sql.Timestamp modifieddate;

    private boolean statususerid;

    @Override
    public String toString() {
        return "userData{" +
                "id=" + id +
                ", user_id='" + userid + '\'' +
                ", email='" + email + '\'' +
                ", nomor_kartu='" + nomorkartu + '\'' +
                ", nomor_hp='" + nomorhp + '\'' +
                ", created_date=" + createddate +
                ", modified_date=" + modifieddate +
                ", status_user_id=" + statususerid +
                '}';
    }

}
