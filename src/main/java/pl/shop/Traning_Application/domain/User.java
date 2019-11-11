package pl.shop.Traning_Application.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_generator")
    @SequenceGenerator(name = "user_generator" , sequenceName = "user_seq")
    @Column(name = "ID" , updatable = false , nullable = false)
    private Long id;

    @Column(unique = true)
    private String username;
    private String activationCode;
    private boolean activated = false;
    @Column( unique = true)
    private String email;
    private String password;
    @Column(columnDefinition ="varchar(255) default 'USER'" )
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Training> training;



}
