package web.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.model.entities.Todo;
import web.model.entities.User;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    Todo findByUserid(User user_id);
}
