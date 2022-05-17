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
@Table(name="rating")
public class Rating {
    @Id
    @Column(name = "rating_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rating_id;

    @Column(name = "comment")
    private String comment;
    @Column(name = "safety")
    private String safety;
    @Column(name = "quality")
    private String quality;

    @ManyToOne(cascade = CascadeType.ALL)
    private Activity activity;


}
