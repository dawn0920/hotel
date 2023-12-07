package kr.ac.mjc.hotel.controller;

import kr.ac.mjc.hotel.domain.Hotelroom;
import kr.ac.mjc.hotel.domain.Reservation;
import kr.ac.mjc.hotel.dto.AddReservationRequest;
import kr.ac.mjc.hotel.repository.HotelroomRepository;
import kr.ac.mjc.hotel.repository.ReservationRepository;
import kr.ac.mjc.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final HotelroomRepository hotelroomRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, HotelroomRepository hotelroomRepository) {
        this.reservationRepository = reservationRepository;
        this.hotelroomRepository = hotelroomRepository;
    }
    ReservationService reservationService;


    @PostMapping("/api/hotel/reservation")
    public ResponseEntity<Reservation> saveReservation(@RequestBody AddReservationRequest request){
        Reservation saveRequest = reservationService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveRequest);
    }

    @GetMapping("/reservationslist")
    public String showReservations(Model model) {
        List<Reservation> reservations = reservationRepository.findAll();
        List<Hotelroom> hotelroom = hotelroomRepository.findAll();

        model.addAttribute("reservations", reservations);
        model.addAttribute("hotelroom", hotelroom);

        return "reservationList";
    }



}
