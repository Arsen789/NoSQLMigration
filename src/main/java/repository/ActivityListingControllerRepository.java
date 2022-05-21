package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import travel_appModel.Activity;
import travel_appModel.ActivityListing;
@Repository
public interface ActivityListingControllerRepository extends JpaRepository<ActivityListing,Long> {

    //all crud methods
}
