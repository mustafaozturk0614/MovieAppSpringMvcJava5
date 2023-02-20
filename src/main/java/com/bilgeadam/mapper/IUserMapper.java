package com.bilgeadam.mapper;


import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.dto.response.UserRegisterResponseDto;
import com.bilgeadam.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {


    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);


    User toUser(final UserRegisterRequestDto dto);

    UserRegisterResponseDto toUserRegisterResponseDto(final User user);

    LoginResponseDto toLoginResponseDto(final User user);
}
