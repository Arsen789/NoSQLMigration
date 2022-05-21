package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import travel_appModel.RatePosting;
@Repository
public interface RatePostingRepository extends JpaRepository<RatePosting,Long> {


}
