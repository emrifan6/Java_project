package web.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.model.entities.Password;

@Repository
public interface PasswordRepository extends CrudRepository<Password, String> {
    Password findByUserid(String user_id);
}
