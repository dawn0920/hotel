package kr.ac.mjc.hotel.service;



import kr.ac.mjc.hotel.domain.Inquiry;
import kr.ac.mjc.hotel.dto.InquiryForm;
import kr.ac.mjc.hotel.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {

    @Autowired
    InquiryRepository inquiryRepository;
    public Inquiry save(InquiryForm inquiryForm){
        return inquiryRepository.save(inquiryForm.toEntity());
    }
}