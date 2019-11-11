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
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "exercise_generator")
    @SequenceGenerator(name = "exercise_generator" , sequenceName = "exercise_seq")
    @Column(name = "ID" , updatable = false , nullable = false)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @OneToMany(mappedBy = "exercise")
    private List<Reps> reps;

    @Enumerated(EnumType.ORDINAL)
    private Muscle muscle;


}
