package pl.shop.Traning_Application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reps {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reps_generator")
    @SequenceGenerator(name = "reps_generator" , sequenceName = "reps_seq")
    @Column(name = "ID" , updatable = false , nullable = false)
    private Long id;
    private int count;

    @ManyToOne
    @JoinColumn(name = "Training_ID")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "Exercise_ID")
    private Exercise exercise;
}
