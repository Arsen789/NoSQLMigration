package repository;

import org.springframework.data.repository.CrudRepository;
import travel_appModel.Activity;
import travel_appModel.ActivityListing;

public interface ActivityListingControllerRepository extends CrudRepository<ActivityListing,Long> {

    //all crud methods
}
