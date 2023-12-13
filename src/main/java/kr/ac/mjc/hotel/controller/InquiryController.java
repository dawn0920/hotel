package kr.ac.mjc.hotel.controller;

import kr.ac.mjc.hotel.domain.Inquiry;
import kr.ac.mjc.hotel.dto.InquiryForm;
import kr.ac.mjc.hotel.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InquiryController {

    @Autowired
    InquiryService inquiryService;

    @GetMapping("/inquiry")
    public String showInquiryForm(Model model) {
        model.addAttribute("inquiryForm", new InquiryForm());
        return "inquiry";
    }



    @GetMapping("/success")
    public String showSuccessPage(Model model) {
        // 성공 페이지에서도 나의 문의 내역 리스트 페이지로의 링크를 제공
        model.addAttribute("myInquiriesLink", "/my-inquiries");
        return "success";
    }

    // 나의 문의 내역 리스트 페이지를 표시하는 핸들러 추가
    @GetMapping("/my-inquiries")
    public String showMyInquiries(Model model) {
        // 여기에 나의 문의 내역을 가져오는 로직을 추가
        // model.addAttribute("myInquiries", inquiryService.getMyInquiries());
        return "MyInquiries";
    }
}
