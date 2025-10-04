package com.dexterv.financetracker.mappers;

import com.dexterv.financetracker.domain.dtos.UserSignupResponseDto;
import com.dexterv.financetracker.domain.dtos.UserSignupRequestDto;
import com.dexterv.financetracker.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    // from dto > User Entity
    User userSignupRequestFromDto(UserSignupRequestDto userSignupRequestDto);

    // from User Entity > dto
    UserSignupResponseDto userSignupResponseToDto (User user);
}
