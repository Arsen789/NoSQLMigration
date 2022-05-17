package travel_appModel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data //generates getters and setters
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name="guide")
public class Guide  extends User {

    @Column(name = "average_rating",nullable = false)
    private String average_rating;
    @Column(name = "number_of_tours",nullable = false)
    private String number_of_tours;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Activity> activities = new HashSet<>();


}
