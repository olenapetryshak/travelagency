package com.softserve.travelagency.service;

import com.softserve.travelagency.dto.UserDTO;
import com.softserve.travelagency.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    User findById(Long id);

    Optional<User> findByName(String name);

    List<User> findAllUsers();
}
