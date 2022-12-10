package web.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.model.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserid(String user_id);
}
