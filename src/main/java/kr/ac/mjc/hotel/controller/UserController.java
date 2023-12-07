package kr.ac.mjc.hotel.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.hotel.dto.UserRequest;
import kr.ac.mjc.hotel.dto.UserResponse;
import kr.ac.mjc.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("api/join")
    public ResponseEntity<UserResponse> join(@RequestBody UserRequest request){
        UserResponse response = userService.join(request);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("api/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest request, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession(true);
        UserResponse response = userService.login(request);

        if(!response.isSuccess()){ // 로그인에 실패한 경우
            return ResponseEntity.ok().body(response);
        }
        // 로그인에 성공한 경우
        session.setAttribute("name", response.getUser().getEmail());
        return ResponseEntity.ok().body(response);
    }


}
