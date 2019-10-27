package pl.shop.Traning_Application.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotEmpty
    private String name;
    @NotEmpty
    private String muscle;
    @NotEmpty
    private String description;
   // private Category category;
    // private byte[] image;

}
