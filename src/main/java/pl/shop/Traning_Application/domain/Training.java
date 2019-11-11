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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "training_generator")
    @SequenceGenerator(name = "training_generator" , sequenceName = "training_seq")
    @Column(name = "ID" , updatable = false , nullable = false)
    private Long id;

    @NotEmpty
    private String name;
    private String note;

    @OneToMany(mappedBy = "training")
    private List<Reps> reps;

    @ManyToOne
    private User user;


}
