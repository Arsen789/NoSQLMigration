package travel_appModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data //generates getters and setters
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="user")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "registration_code",nullable = false)
    private String registration_code;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "bio")
    private String bio;

   // @ManyToMany(cascade = CascadeType.ALL,mappedBy = "Guide")
   // private Set<Guide> guides = new HashSet<>();


}
