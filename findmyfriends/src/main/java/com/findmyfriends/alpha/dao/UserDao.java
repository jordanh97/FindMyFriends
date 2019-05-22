package com.findmyfriends.alpha.dao;

import com.findmyfriends.alpha.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    int insertUser(UUID id, User user);


    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    int deleteUserById(UUID id);

    int updateUserById(UUID id, User user);

    Optional<User> selectUserById(UUID id);
}
