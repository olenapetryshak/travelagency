package com.softserve.travelagency.repository.impl;

import com.softserve.travelagency.entity.Role;
import com.softserve.travelagency.repository.RoleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public Role findByName(String name) {
        return null;
    }
}
