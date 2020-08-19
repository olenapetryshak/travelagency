package com.softserve.travelagency.repository;

import com.softserve.travelagency.entity.Role;
import org.springframework.stereotype.Repository;

public interface RoleRepository {
    Role findByName(String name);
}
