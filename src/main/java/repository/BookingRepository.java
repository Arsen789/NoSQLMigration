package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import travel_appModel.Booking;

public interface BookingRepository extends CrudRepository<Booking,Long> {

}
