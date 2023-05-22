package africa.semicolon.muve.controller;

import africa.semicolon.muve.data.dto.requests.RegisterPassengerRequest;
import africa.semicolon.muve.data.dto.responses.ApiResponse;
import africa.semicolon.muve.data.dto.responses.RegisterResponse;
import africa.semicolon.muve.data.models.Passenger;
import africa.semicolon.muve.service.PassengerService;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    private PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegisterPassengerRequest registerPassengerRequest) {
        RegisterResponse registerResponse = passengerService.register(registerPassengerRequest);
        return ResponseEntity.status(registerResponse.getCode()).body(registerResponse);
//        return new ResponseEntity<>(registerResponse, HttpStatus.OK);
    }

    @GetMapping("{passengerId}")
    public ResponseEntity<?> getPassengerById(@PathVariable Long passengerId){
        var foundPassenger = passengerService.getPassengerById(passengerId);
        return ResponseEntity.status(HttpStatus.OK).body(foundPassenger);
//        return new ResponseEntity<>(foundPassenger, HttpStatus.OK);
    }

    @PatchMapping(value = "{passengerId}", consumes = "application/json-patch+json")
    public ResponseEntity<?> updatePassenger(@PathVariable Long passengerId, @RequestBody JsonPatch updatePatch){
        try {
            Passenger response = passengerService.updatePassenger(passengerId, updatePatch);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @DeleteMapping("{passengerId}")
    public ResponseEntity<?> deletePassenger(@PathVariable Long passengerId){
        passengerService.deletePassenger(passengerId);
        return ResponseEntity.ok(ApiResponse.builder().message("Passenger deleted successfully"));
    }

//    @GetMapping(value = "all")
//    public ResponseEntity<?> getAllPassengers(@PathVariable int pageNumber) {
//
//    }
}
