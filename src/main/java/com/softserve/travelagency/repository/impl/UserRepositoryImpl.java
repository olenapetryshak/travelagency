package com.softserve.travelagency.repository.impl;

import com.softserve.travelagency.entity.User;
import com.softserve.travelagency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;

    @Autowired
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.username = ?1", User.class);
        query.setParameter(1, username);
        return Optional.of(query.getSingleResult());
    }

    @Override
    public User findById(Long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = ?1", User.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public List<User> findAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }
}
