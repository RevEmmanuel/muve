package africa.semicolon.muve.data.repositories;

import africa.semicolon.muve.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
