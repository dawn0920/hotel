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

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final HotelroomRepository hotelroomRepository;


    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, HotelroomRepository hotelroomRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.hotelroomRepository = hotelroomRepository;
    }

    public Reservation save(AddReservationRequest request, String email) {
        User loginUser = userRepository.findByEmail(email);
        Reservation reservation = request.toEntity();


        return reservationRepository.save(reservation);
    }


    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public static boolean isFirstDateEarlier(Date res_f_date, Date res_e_date) {
        return res_f_date.before(res_e_date);
    }
}



