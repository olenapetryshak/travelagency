package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findByUsername(String username);

    User findById(Long id);

    List<User> findAllUsers();
}
