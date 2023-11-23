package kr.ac.mjc.hotel.service;

import kr.ac.mjc.hotel.domain.Reservation;
import kr.ac.mjc.hotel.dto.AddReservationRequest;
import kr.ac.mjc.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public Reservation save(AddReservationRequest request){
        return reservationRepository.save(request.toEntity());
    }
}
