package security.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import security.oauth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
