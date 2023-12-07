package kr.ac.mjc.hotel.repository;

import kr.ac.mjc.hotel.domain.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry,Long> {
}