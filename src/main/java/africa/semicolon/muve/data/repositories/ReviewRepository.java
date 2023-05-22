package africa.semicolon.muve.data.repositories;

import africa.semicolon.muve.data.models.Driver;
import africa.semicolon.muve.data.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {


}
