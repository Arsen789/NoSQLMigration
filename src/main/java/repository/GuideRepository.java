package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import travel_appModel.Guide;
@Repository
public interface GuideRepository extends JpaRepository<Guide,String> {


}
