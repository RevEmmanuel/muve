package africa.semicolon.muve.data.repositories;

import africa.semicolon.muve.data.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <AppUser, Long> {


}
