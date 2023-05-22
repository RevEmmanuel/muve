package africa.semicolon.muve.data.repositories;

import africa.semicolon.muve.data.models.BankInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankInformationRepository extends JpaRepository <BankInformation, Long> {
}
