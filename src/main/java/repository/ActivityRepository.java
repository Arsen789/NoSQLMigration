package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import travel_appModel.Activity;
@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

    //all crud methods
}
