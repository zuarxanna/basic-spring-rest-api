package net.javaguides.springboot.models.repos;

import net.javaguides.springboot.models.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Long>{

}
