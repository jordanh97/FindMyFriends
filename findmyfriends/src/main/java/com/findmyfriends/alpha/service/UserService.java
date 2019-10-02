package com.findmyfriends.alpha.service;

import com.findmyfriends.alpha.domain.User;

import java.util.Set;

public interface UserService extends IService<User, String> {

    Set<User> getAll();
}
