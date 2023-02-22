package com.bilgeadam.controller;

import com.bilgeadam.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/moviecommnet")
@RequiredArgsConstructor
public class MovieCommentController {

private final MovieCommentService movieCommentService;



   @PostMapping("/save")
    public  void save(Long userId,Long movieId,String content){
       System.out.println("info="+userId+movieId+content);
  }

}
