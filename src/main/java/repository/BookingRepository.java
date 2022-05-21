package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import travel_appModel.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

}
