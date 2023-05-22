package africa.semicolon.muve.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BankInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String bankName;
    private String accountNumber;
    private String accountName;
}
