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
@Table(name="ratePosting")
public class RatePosting {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratePosting_id;

    @Column(name = "rating_date")
    private String rating_date;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    Rating rating;

    @ManyToMany
    @JoinColumn(name = "user_id")
    Tourist tourist;
}
