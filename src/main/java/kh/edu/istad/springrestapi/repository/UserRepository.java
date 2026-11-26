
package kh.edu.istad.springrestapi.repository;

import kh.edu.istad.springrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}