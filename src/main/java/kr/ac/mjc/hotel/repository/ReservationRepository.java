package kr.ac.mjc.hotel.repository;

import kr.ac.mjc.hotel.domain.Reservation;
import kr.ac.mjc.hotel.dto.AddReservationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

}
