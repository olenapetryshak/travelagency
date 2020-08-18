package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> findAllUsers();
}
