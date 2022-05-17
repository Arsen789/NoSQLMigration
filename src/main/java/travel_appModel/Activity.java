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
@Entity
@Builder
@Table(name="activity")
public class Activity {
    @Id
    @Column(name = "activity_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activity_id;

    @Column(name = "title")
    private String Title;
    @Column(name = "description")
    private String Description;


    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "activity")
    @JoinColumn(name="rating_id",nullable = false)
    private Set<Rating> rating = new HashSet<>();

    @JoinColumn(name="booking_id",nullable = false)
    private Set<Booking> booking = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",nullable = false)
    private Set<Guide> guides = new HashSet<>();
}
