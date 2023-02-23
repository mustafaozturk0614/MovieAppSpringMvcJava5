package com.bilgeadam.controller;

import com.bilgeadam.dto.request.MovieCommentCreateRequestDto;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.MovieComment;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.MovieCommentService;
import com.bilgeadam.service.MovieService;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/moviecomment")
@RequiredArgsConstructor
public class MovieCommentController {

private final MovieCommentService movieCommentService;



   @PostMapping("/save")
    public ModelAndView save(MovieCommentCreateRequestDto dto){
       movieCommentService.save(dto);
       ModelAndView modelAndView=new ModelAndView();
       modelAndView.addObject("id",dto.getMovieId());
       modelAndView.addObject("userId",dto.getUserId());
       modelAndView.setViewName("redirect:/movie/findbyid");
      // modelAndView.setViewName("redirect:/movie/findbyid?id="+dto.getMovieId()+"&userId="+dto.getUserId());
       return modelAndView;
  }

}
