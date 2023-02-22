package com.bilgeadam.controller;

import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.GenreService;
import com.bilgeadam.service.MovieService;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final GenreService genreService;
    private final MovieService movieService;

    private final UserService userService;

    @GetMapping("")
    public ModelAndView getMoviePage( LoginResponseDto responseDto){
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("response==>"+responseDto);
        List<Movie> movieList=movieService.findAll();
        modelAndView.addObject("genres",genreService.findAll());
        modelAndView.addObject("user",responseDto);
        modelAndView.addObject("movies",movieList);
        modelAndView.setViewName("movies");
        return  modelAndView;
    }


    @GetMapping("/findbyid")
    public ModelAndView getById(Long id,Long userId){
        User user =null;
        if (userId==null){
            user=User.builder().build();
        }else{
            user =userService.findById(userId).get();
        }

        Movie movie=movieService.findbyId(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("movie",movie);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("moviesDetail");
        return modelAndView;
    }



}
