package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import travel_appModel.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
