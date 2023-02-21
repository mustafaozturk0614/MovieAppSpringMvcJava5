package com.bilgeadam.controller;
/*
   1-Mvc yapýsýnda register metotlarýmýzý yazalým


 */

import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.dto.response.UserRegisterResponseDto;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.service.GenreService;
import com.bilgeadam.service.MovieService;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final GenreService genreService;
    private final MovieService movieService;

private  final UserService userService;

@GetMapping("/register")
public ModelAndView getRegisterPage(){
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.addObject("error","");
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
        modelAndView.addObject("email",userRegisterResponseDto.getEmail());  //1.yöntem
       modelAndView.setViewName("redirect:login");
   //     return  getLoginPage(dto.getEmail());  //2.yöntem
    }catch (Exception e){
        error=e.getMessage();
        modelAndView.addObject("error",error);
//    modelAndView.setViewName("redirect:register");
        modelAndView.setViewName("register");
    }

    return modelAndView;
}


   @GetMapping("/login")
    public ModelAndView getLoginPage(String email){
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.addObject("email",email);
    modelAndView.setViewName("login");
        return modelAndView;
}
    @PostMapping("/login")
    public ModelAndView login(LoginRequestDto dto){
        ModelAndView modelAndView=new ModelAndView();
        try {
         LoginResponseDto responseDto=userService.login(dto);
            List<Movie> movieList=movieService.findAll();
          //  modelAndView.addObject("result","Giriþ Baþarýlý");
            modelAndView.addObject("genres",genreService.findAll());
            modelAndView.addObject("user",responseDto);
            modelAndView.addObject("movies",movieList);
            modelAndView.setViewName("movies");
        }catch (Exception e){
            modelAndView.addObject("result",e.getMessage());
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }
}
