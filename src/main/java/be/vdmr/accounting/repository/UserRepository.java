package be.vdmr.accounting.repository;

import be.vdmr.accounting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);
}
