package com.bilgeadam.controller;
/*
   1-Mvc yap�s�nda register metotlar�m�z� yazal�m


 */

import com.bilgeadam.dto.request.FavMoviesRequestDto;
import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.dto.response.UserRegisterResponseDto;
import com.bilgeadam.service.GenreService;
import com.bilgeadam.service.MovieService;
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
    private final GenreService genreService;
    private final MovieService movieService;

    private final  MovieController movieController;

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
        modelAndView.addObject("email",userRegisterResponseDto.getEmail());  //1.y�ntem
       modelAndView.setViewName("redirect:login");
   //     return  getLoginPage(dto.getEmail());  //2.y�ntem
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
            //  modelAndView.addObject("result","Giri� Ba�ar�l�");
//            modelAndView.addObject("id",responseDto.getId());//1.yontem
//            modelAndView.setViewName("redirect:/movie");
       return   movieController.getMoviePage(responseDto);//2.yontem
        }catch (Exception e){
            modelAndView.addObject("result",e.getMessage());
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

    @GetMapping("/addfavmovies")
    public  ModelAndView  addFavMovies(FavMoviesRequestDto dto){
        ModelAndView modelAndView=new ModelAndView();
        userService.addFavMovies(dto);
        modelAndView.addObject("id",dto.getMovieId());
        modelAndView.addObject("userId",dto.getUserId());
        modelAndView.setViewName("redirect:/movie/findbyid");
        // modelAndView.setViewName("redirect:/movie/findbyid?id="+dto.getMovieId()+"&userId="+dto.getUserId());

        return modelAndView;
    }

    @GetMapping("/removefavmovies")
    public  ModelAndView  removeFavMovies(FavMoviesRequestDto dto){
        ModelAndView modelAndView=new ModelAndView();
        userService.removeFavMovies(dto);
        modelAndView.addObject("id",dto.getMovieId());
        modelAndView.addObject("userId",dto.getUserId());
        modelAndView.setViewName("redirect:/movie/findbyid");
        // modelAndView.setViewName("redirect:/movie/findbyid?id="+dto.getMovieId()+"&userId="+dto.getUserId());

        return modelAndView;
    }
}
