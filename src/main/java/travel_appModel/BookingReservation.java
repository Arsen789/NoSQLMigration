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
@Table(name="bookingReservation")
public class BookingReservation {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingReservation_id;

    @Column(name = "reservation_date")
    private String reservation_date;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    Booking booking;

    @ManyToMany
    @JoinColumn(name = "user_id")
    Tourist tourist;

}
