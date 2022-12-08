package web.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.model.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserid(String user_id);
}
