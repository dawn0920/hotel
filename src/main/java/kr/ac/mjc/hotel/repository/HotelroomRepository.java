package kr.ac.mjc.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kr.ac.mjc.hotel.domain.Hotelroom;

@Repository
public interface HotelroomRepository extends JpaRepository<Hotelroom, Long> {

}