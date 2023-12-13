package kr.ac.mjc.hotel.controller;

import kr.ac.mjc.hotel.domain.Inquiry;
import kr.ac.mjc.hotel.dto.InquiryForm;
import kr.ac.mjc.hotel.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InquiryRestController {


    @Autowired
    InquiryService inquiryService;

    @PostMapping("/submit")
    public ResponseEntity<Inquiry> submitInquiry(
            @RequestBody InquiryForm inquiryForm
    ) {
        System.out.println(inquiryForm.getName());
        // 여기서 동의 여부(agree)에 따른 로직을 추가할 수 있습니다.
        // 동의한 경우에만 데이터를 저장하도록 구현할 수 있습니다.
        Inquiry savedInquiry=inquiryService.save(inquiryForm);

        return ResponseEntity.ok().body(savedInquiry);
//        ModelAndView mav=new ModelAndView();
//        mav.setViewName("MyInquires");
//        mav.addObject("MyInquires",savedInquiry);
//        return mav;

    }


}