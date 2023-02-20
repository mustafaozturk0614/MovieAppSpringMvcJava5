package com.bilgeadam.service;


import com.bilgeadam.repository.IMovieCommentRepository;
import com.bilgeadam.repository.entity.MovieComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCommentService {

    private final IMovieCommentRepository movieCommentRepository;


  public   List<MovieComment> findAllByMyMovies(Long movieId){
        return movieCommentRepository.findAllByMyMovies(movieId);
    }

    public   List<MovieComment> findAllByMovie_Id(Long movieId){
        return movieCommentRepository.findAllByMovie_Id(movieId);
    }

    public  List<MovieComment> findAllByUser_Id(Long userId){

      return movieCommentRepository.findAllByUser_Id(userId);
    }

    public List<MovieComment> findAllByDateBetweenAndUser_Id(String start, String end, Long userId ){
        return movieCommentRepository.findAllByDateBetweenAndUser_Id(LocalDate.parse(start)
                ,LocalDate.parse(end),userId);
    }

    public List<MovieComment> findAllByDateBetweenAndMovie_Id(String start, String end, Long movieId ){
        return movieCommentRepository.findAllByDateBetweenAndMovie_Id(LocalDate.parse(start)
                ,LocalDate.parse(end),movieId);
    }


    public  List<MovieComment> findAllByContentContainingIgnoreCase(String value){

      return movieCommentRepository.findAllByContentContainingIgnoreCase(value);
    }

    public    List<MovieComment> findAllByContentSize(int length){

      return movieCommentRepository.findAllByContentSize(length);
    }

        public   List<String> findAllByContentSizeString(int length){

      return movieCommentRepository.findAllByContentSizeString(length);
        }

}
