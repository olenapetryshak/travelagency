package com.softserve.travelagency.service.mapper;

import com.softserve.travelagency.dto.UserDTO;
import com.softserve.travelagency.entity.User;
import com.softserve.travelagency.entity.UserDetailsImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);

    @Mapping(target = "enabled", source = "isEnabled")
    UserDetailsImpl toUserDetails(User user, boolean isEnabled);

}
