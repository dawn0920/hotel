package kr.ac.mjc.hotel.service;

import kr.ac.mjc.hotel.domain.Hotelroom;
import kr.ac.mjc.hotel.domain.Reservation;
import kr.ac.mjc.hotel.domain.User;
import kr.ac.mjc.hotel.dto.AddReservationRequest;
import kr.ac.mjc.hotel.repository.HotelroomRepository;
import kr.ac.mjc.hotel.repository.ReservationRepository;
import kr.ac.mjc.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    @Autowired
    HotelroomRepository hotelroomRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public Reservation save(AddReservationRequest request, String email) {
        User loginUser = userRepository.findByEmail(email);
        Reservation reservation = request.toEntity();

        // 선택된 객실 타입을 가져와서 Hotelroom 객체로 변환
        Hotelroom hotelroom = new Hotelroom();
        String roomAsString = hotelroom.toString();
        Hotelroom roomTypeEntity = hotelroomRepository.findByRoom(request.getRoom_type());
        reservation.setRester(loginUser);
        reservation.setRoom_type(roomTypeEntity);

        return reservationRepository.save(reservation);
    }


    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

}

