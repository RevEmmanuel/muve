package africa.semicolon.muve.data.repositories;

import africa.semicolon.muve.data.models.Driver;
import africa.semicolon.muve.data.models.Referee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefereeRepository extends JpaRepository<Referee, Long> {


}
