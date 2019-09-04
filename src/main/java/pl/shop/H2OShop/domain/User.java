package pl.shop.H2OShop.domain;


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
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String activationCode;
    private boolean activated = false;
    @Column( unique = true)
    private String email;
    private String password;


    private String address;
    private String city;
    private String country;
    private String zipCode;


}
