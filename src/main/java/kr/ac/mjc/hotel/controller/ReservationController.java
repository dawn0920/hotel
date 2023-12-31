package kr.ac.mjc.hotel.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.hotel.domain.Hotelroom;
import kr.ac.mjc.hotel.domain.Reservation;
import kr.ac.mjc.hotel.domain.User;
import kr.ac.mjc.hotel.dto.AddReservationRequest;
import kr.ac.mjc.hotel.dto.ReservationResponse;
import kr.ac.mjc.hotel.repository.HotelroomRepository;
import kr.ac.mjc.hotel.repository.ReservationRepository;
import kr.ac.mjc.hotel.repository.UserRepository;
import kr.ac.mjc.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@Controller
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final HotelroomRepository hotelroomRepository;

    @Autowired
    ReservationService reservationService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, HotelroomRepository hotelroomRepository) {
        this.reservationRepository = reservationRepository;
        this.hotelroomRepository = hotelroomRepository;
    }


    @PostMapping("/api/reservation")
    public ResponseEntity<ReservationResponse> saveReservation(@RequestBody AddReservationRequest request,
                                                               HttpServletRequest httpServletRequest) {

        HttpSession session = httpServletRequest.getSession(true);
        String email = (String) session.getAttribute("email");

        ReservationResponse response = new ReservationResponse();
        if (email == null) { // 로그인 되어있지 않은 경우
            response.setSuccess(false);
            response.setMessage("로그인 후 작성 가능합니다.");
            return ResponseEntity.ok().body(response);
        }

        User user = userRepository.findByEmail(email);
        request.setRester(user);

        Reservation saveRequest = reservationService.save(request, email);
        response.setSuccess(true);
        response.setMessage("글 작성이 완료되었습니다");
        response.setReservation(saveRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/reservationslist")
    public String showUserReservations(Model model, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        String email = (String) session.getAttribute("email");

        // 모델에 사용자 이메일 추가
        model.addAttribute("email", email);

        if (email != null) {
            User user = userRepository.findByEmail(email);
            List<Reservation> userReservations = reservationRepository.findByRester(user);

            model.addAttribute("reservations", userReservations);
            return "reservationList";
        } else {
            // 로그인되지 않은 경우에 대한 처리 (예: 로그인 페이지로 리다이렉트)
            return "redirect:/login"; // 적절한 로그인 페이지 URL로 변경
        }
    }
}