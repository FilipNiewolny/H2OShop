package pl.shop.Traning_Application.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Training implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotEmpty
    private String name;
    private String note;

    @OneToMany(mappedBy = "training")
    private List<Reps> reps;

    @ManyToOne
    private User user;


}
