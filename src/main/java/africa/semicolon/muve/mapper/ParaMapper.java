package africa.semicolon.muve.mapper;

import africa.semicolon.muve.data.dto.requests.RegisterPassengerRequest;
import africa.semicolon.muve.data.models.AppUser;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParaMapper {

    public static AppUser map(RegisterPassengerRequest registerPassengerRequest) {
        AppUser appUser = new AppUser();
        appUser.setName(registerPassengerRequest.getName());
        appUser.setEmail(registerPassengerRequest.getEmailAddress());
        appUser.setPassword(registerPassengerRequest.getPassword());
        return appUser;
    }
}
