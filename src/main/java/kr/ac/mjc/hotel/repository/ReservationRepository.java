package kr.ac.mjc.hotel.repository;

import kr.ac.mjc.hotel.domain.Reservation;
import kr.ac.mjc.hotel.domain.User;
import kr.ac.mjc.hotel.dto.AddReservationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByRester(User var1);
}
