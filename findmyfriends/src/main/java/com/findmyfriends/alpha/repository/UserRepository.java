package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.User;
import com.findmyfriends.alpha.repository.IRepository;

import java.util.Set;

public interface UserRepository extends IRepository<User, String>{

    Set<User> getAll();
}
