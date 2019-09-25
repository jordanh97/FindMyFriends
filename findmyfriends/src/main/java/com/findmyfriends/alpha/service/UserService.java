package com.findmyfriends.alpha.service;

import com.findmyfriends.alpha.domain.User;
import com.findmyfriends.alpha.repository.IRepository;

import java.util.Set;

public interface UserService extends IRepository<User, String> {

    Set<User> getAll();
}
