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
@Builder
@Entity
@Table(name="booking")
public class Booking {

    @Id
    @Column(name = "booking_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long booking_id;

    private java.sql.Date booking_date;


    @ManyToOne(cascade = CascadeType.ALL)
    private Activity activity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="booking_tourists",nullable = false)
    private Set<Tourist> tourists = new HashSet<>();



}
