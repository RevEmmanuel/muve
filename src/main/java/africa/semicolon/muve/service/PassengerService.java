package africa.semicolon.muve.service;

import africa.semicolon.muve.data.dto.requests.RegisterPassengerRequest;
import africa.semicolon.muve.data.dto.responses.RegisterResponse;
import africa.semicolon.muve.data.models.Passenger;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.data.domain.Page;

public interface PassengerService {

    RegisterResponse register(RegisterPassengerRequest registerPassengerRequest);

    Passenger getPassengerById(Long userId);

    Passenger updatePassenger(Long passengerId, JsonPatch updatePayload);

    void deletePassenger(Long passengerId);

    Page<Passenger> getAllPassengers(int pageNumber);
}
