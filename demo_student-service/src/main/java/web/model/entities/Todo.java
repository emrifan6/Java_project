package web.model.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn(referencedColumnName = "userid")
    // private User userid;

    @Column(nullable = true)
    private String desc;

    private LocalDate targetdate;

    private boolean isdone;

    @OneToMany(mappedBy = "td_userid")
    private User userid;

    @Override
    public String toString() {
        return "userData{" +
                "id=" + id +
                ", user_id='" + userid + '\'' +
                ", desc='" + desc + '\'' +
                ", targetdate='" + targetdate + '\'' +
                ", isdone='" + isdone +
                '}';
    }
}
