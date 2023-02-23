package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.MovieCommentCreateRequestDto;
import com.bilgeadam.repository.entity.MovieComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMovieCommentMapper {


    IMovieCommentMapper INSTANCE= Mappers.getMapper(IMovieCommentMapper.class);


    MovieComment toMovieComment(final MovieCommentCreateRequestDto dto);

}
