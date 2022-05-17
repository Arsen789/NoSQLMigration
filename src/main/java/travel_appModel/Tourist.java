package travel_appModel;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data //generates getters and setters
@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
@Table(name="tourist")
public class Tourist extends User {

    @Column(name = "data_of_birth",nullable = false)
    private String data_of_birth;

    @Column(name = "living_location",nullable = false)
    private String living_location;

    @JoinColumn(name="rating_id",nullable = false)
    private Set<Rating> rating = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "tourist")
    private Set<Booking> bookings = new HashSet<>();

}
