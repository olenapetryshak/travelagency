package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dto.UserDTO;
import com.softserve.travelagency.entity.Role;
import com.softserve.travelagency.entity.User;
import com.softserve.travelagency.repository.RoleRepository;
import com.softserve.travelagency.repository.UserRepository;
import com.softserve.travelagency.service.UserService;
import com.softserve.travelagency.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        Role role = roleRepository.findByName("ROLE_USER");
        user.getRoles().add(role);
        user.setPassword(encoder.encode(userDTO.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
}
