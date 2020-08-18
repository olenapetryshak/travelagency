package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.entity.User;
import com.softserve.travelagency.repository.UserRepository;
import com.softserve.travelagency.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
}
