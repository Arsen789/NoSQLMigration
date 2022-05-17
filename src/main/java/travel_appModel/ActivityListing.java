package travel_appModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data //generates getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="activityListing")
public class ActivityListing {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activity_id;


    @Column(name = "location")
    private String location;

    @Column(name = "activity_date")
    private String activity_date;

    @Column(name = "listing_date")
    private String listing_date;


}