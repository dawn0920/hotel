package kr.ac.mjc.hotel.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.hotel.domain.Hotelroom;
import kr.ac.mjc.hotel.domain.Reservation;
import kr.ac.mjc.hotel.domain.User;
import kr.ac.mjc.hotel.repository.HotelroomRepository;
import kr.ac.mjc.hotel.repository.ReservationRepository;
import kr.ac.mjc.hotel.service.ReservationService;
import kr.ac.mjc.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Scanner;

@Controller
public class ViewController {

    private final HotelroomRepository hotelroomRepository;

    @Autowired
    public ViewController(HotelroomRepository hotelroomRepository) {
        this.hotelroomRepository = hotelroomRepository;
    }

    @Autowired
    UserService userService;

    @Autowired
    ReservationService reservationService;

    @GetMapping("/main")
    public String newArticle(HttpServletRequest httpServletRequest, Model model) {
        HttpSession session = httpServletRequest.getSession(true);

        // 세션에 저장된 사용자 id
        String email = (String) session.getAttribute("email");

        // 모델에 사용자 이메일 추가
        model.addAttribute("email", email);

        return "main";
    }


    @GetMapping("/locate")
    public ModelAndView getLocate(){
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    @GetMapping("/info")
    public ModelAndView getInfo(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("info");
        return mav;
    }

    @GetMapping("/join")
    public ModelAndView getJoin(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("join");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView getLogin(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        return "/main";
    }

    @GetMapping("/hotel_reservation")
    public String newArticle(HttpServletRequest httpServletRequest, Model model, String name) {
        List<Hotelroom> hotelroom = hotelroomRepository.findAll();
        model.addAttribute("hotelroom", hotelroom);

        HttpSession session = httpServletRequest.getSession(true);
        String email = (String) session.getAttribute("email");

        if (email == null) {
            return "login";
        }

        // 사용자가 선택한 객실 타입을 컨트롤러로 전달
        String selectedRoom = httpServletRequest.getParameter("room_type"); // 수정된 부분
        model.addAttribute("selectedRoom", selectedRoom);


        User loginUser = new User();
        loginUser.setEmail(email);

        // 여기서 User 객체의 다른 필드들도 필요하다면, 해당 정보도 세션 또는 DB 등에서 가져와서 설정

        model.addAttribute("rester", loginUser);

        return "hotel_reservation";
    }




}
