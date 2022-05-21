package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import travel_appModel.Rating;
@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {



}
