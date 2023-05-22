package africa.semicolon.muve.data.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterPassengerRequest {

    @JsonProperty("email")
    private String emailAddress;
    @JsonProperty("full_name")
    private String name;
    @JsonProperty("password")
    private String password;
}
