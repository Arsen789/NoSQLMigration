package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import travel_appModel.Activity;

public interface ActivityRepository extends CrudRepository<Activity,Long> {

    //all crud methods
}
