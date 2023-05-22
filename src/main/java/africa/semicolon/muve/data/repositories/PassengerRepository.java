package africa.semicolon.muve.data.repositories;

import africa.semicolon.muve.data.models.Driver;
import africa.semicolon.muve.data.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
