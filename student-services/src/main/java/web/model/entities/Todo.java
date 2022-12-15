package web.model.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false, referencedColumnName = "id")
    private User iduser;

    @Column(nullable = true)
    private String description;

    private LocalDate targetdate;

    private boolean isdone;

    @Override
    public String toString() {
        return "userData{" +
                "id=" + id +
                ", iduser ='" + iduser + '\'' +
                ", desc='" + description + '\'' +
                ", targetdate='" + targetdate + '\'' +
                ", isdone='" + isdone +
                '}';
    }
}
