package africa.semicolon.muve.data.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterResponse {

    private Long id;
    private int code;
    private boolean isSuccess;
    private String message;
}
