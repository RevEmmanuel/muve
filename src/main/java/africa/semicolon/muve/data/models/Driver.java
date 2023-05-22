package africa.semicolon.muve.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phoneNumber;
    @OneToOne
    private Address address;
    private Gender gender;
    private String licenseId;
    private int age;
    @OneToOne
    private Referee referee;
    @OneToOne
    private BankInformation bankInformation;
    @OneToOne
    private AppUser userDetails;
}
