package kr.ac.mjc.hotel.controller;

import kr.ac.mjc.hotel.domain.Reservation;
import kr.ac.mjc.hotel.dto.AddReservationRequest;
import kr.ac.mjc.hotel.repository.ReservationRepository;
import kr.ac.mjc.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/api/hotel/reservation")
    public ResponseEntity<Reservation> saveReservation(@RequestBody AddReservationRequest request){
        Reservation saveRequest = reservationService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveRequest);

    }



}
