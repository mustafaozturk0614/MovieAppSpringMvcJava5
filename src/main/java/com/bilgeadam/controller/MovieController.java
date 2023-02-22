package com.bilgeadam.controller;

import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.service.GenreService;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final GenreService genreService;
    private final MovieService movieService;

    @GetMapping("")
    public ModelAndView getMoviePage(LoginResponseDto responseDto){
        ModelAndView modelAndView=new ModelAndView();
        System.out.println("response==>"+responseDto);
        List<Movie> movieList=movieService.findAll();
        modelAndView.addObject("genres",genreService.findAll());
        modelAndView.addObject("user",responseDto);
        modelAndView.addObject("movies",movieList);
        modelAndView.setViewName("movies");
        return  modelAndView;
    }


}
