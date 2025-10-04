package com.dexterv.financetracker.mappers;

import com.dexterv.financetracker.domain.dtos.UserResponseDto;
import com.dexterv.financetracker.domain.dtos.UserSignupRequestDto;
import com.dexterv.financetracker.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    // from dto > User Entity
    User userSignupRequestFromDto(UserSignupRequestDto dto);

    // from User Entity > dto
    UserResponseDto toDto (User user);
}
