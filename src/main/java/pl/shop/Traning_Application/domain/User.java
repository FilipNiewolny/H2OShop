package pl.shop.Traning_Application.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String activationCode;
    private boolean activated = false;
    @Column( unique = true)
    private String email;
    private String password;



}
