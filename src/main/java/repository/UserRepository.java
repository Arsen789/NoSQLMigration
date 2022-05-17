package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import travel_appModel.Guide;
import travel_appModel.User;

public interface UserRepository extends CrudRepository<User,Long> {


}
