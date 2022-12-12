package web.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.model.entities.Password;
import web.model.entities.User;

@Repository
public interface PasswordRepository extends CrudRepository<Password, Long> {
    Password findByUserid(User user_id);
}
