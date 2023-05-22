package africa.semicolon.muve.service;

import africa.semicolon.muve.mapper.ParaMapper;
import africa.semicolon.muve.data.dto.requests.RegisterPassengerRequest;
import africa.semicolon.muve.data.dto.responses.RegisterResponse;
import africa.semicolon.muve.data.models.AppUser;
import africa.semicolon.muve.data.models.Passenger;
import africa.semicolon.muve.data.repositories.PassengerRepository;
import africa.semicolon.muve.exception.BusinessLogicException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.io.IOException;

@Service
@AllArgsConstructor
//@Slf4j
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
//    private static int NUMBER_OF_ = ;

    @Override
    public RegisterResponse register(RegisterPassengerRequest registerPassengerRequest) {
//        AppUser appUser = new AppUser();
//        appUser.setEmail(registerPassengerRequest.getEmailAddress());
//        appUser.setPassword(registerPassengerRequest.getPassword());
//        appUser.setName(registerPassengerRequest.getName());
//        JavaTimeModule timeModule = new JavaTimeModule();
        AppUser appUser = ParaMapper.map(registerPassengerRequest);
        appUser.setTime(LocalDateTime.now());

        Passenger passenger = new Passenger();
        passenger.setUserDetails(appUser);
        Passenger svedPassenger = passengerRepository.save(passenger);

        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setId(svedPassenger.getId());
        registerResponse.setCode(HttpStatus.CREATED.value());
        registerResponse.setSuccess(true);
        registerResponse.setMessage("Registration successful!");
        return registerResponse;
    }

    @Override
    public Passenger getPassengerById(Long passengerId) {
        return passengerRepository.findById(passengerId).orElseThrow(() ->
                new BusinessLogicException(
                        String.format("Passenger with id %d not found", passengerId))
        );
    }

    @Override
    public Passenger updatePassenger(Long passengerId, JsonPatch updatePayload) {
        ObjectMapper mapper = new ObjectMapper();
        Passenger foundPassenger = getPassengerById(passengerId);
        //Passenger Object to node
        JsonNode node = mapper.convertValue(foundPassenger, JsonNode.class);
        try {
            //apply patch
            JsonNode updatedNode = updatePayload.apply(node);
            //node to Passenger Object
            var updatedPassenger = mapper.convertValue(updatedNode, Passenger.class);
            updatedPassenger = passengerRepository.save(updatedPassenger);
            return updatedPassenger;

        } catch (JsonPatchException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void deletePassenger(Long passengerId) {
        passengerRepository.deleteById(passengerId);
    }

    @Override
    public Page<Passenger> getAllPassengers(int pageNumber) {
//        if (pageNumber < 1) pageNumber = 0;
//        pageNumber -= 1;
//        Pageable pageable = PageRequest.of(pageNumber, NUMBER_OF_);
//        return passengerRepository.findAll(pageable);
        return null;
    }

}
