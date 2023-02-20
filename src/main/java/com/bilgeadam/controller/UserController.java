package com.bilgeadam.controller;
/*
   1-Mvc yapýsýnda register metotlarýmýzý yazalým


 */

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.UserRegisterResponseDto;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


private  final UserService userService;

@GetMapping("/register")
public ModelAndView getRegisterPage(String error){

    ModelAndView modelAndView=new ModelAndView();
    modelAndView.addObject("error",error);
    modelAndView.setViewName("register");
    return  modelAndView;
}

@PostMapping("/register")
public ModelAndView register(UserRegisterRequestDto dto){
    String error="";
    ModelAndView modelAndView=new ModelAndView();
    UserRegisterResponseDto userRegisterResponseDto=null;
    try {
     userRegisterResponseDto=userService.register2(dto);
        System.out.println("dto==>"+userRegisterResponseDto);
    }catch (Exception e){
        error=e.getMessage();
    }

    modelAndView.addObject("error",error);
    modelAndView.setViewName("redirect:register");

    return modelAndView;
}

}
