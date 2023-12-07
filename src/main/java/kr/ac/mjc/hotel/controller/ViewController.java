package kr.ac.mjc.hotel.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.mjc.hotel.service.ReservationService;
import kr.ac.mjc.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @Autowired
    UserService userService;

    @GetMapping("/main")
    public ModelAndView getMain(){
        ModelAndView mav = new ModelAndView();
        return mav;
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



}
