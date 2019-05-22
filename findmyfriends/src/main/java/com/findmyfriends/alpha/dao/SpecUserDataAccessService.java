package com.findmyfriends.alpha.dao;

import com.findmyfriends.alpha.domain.user.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("userDao")
public class SpecUserDataAccessService implements UserDao{

    private static List<User> DB = new ArrayList<>();


    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id, user.getUsername(), BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())));
        return 1;
    }


    @Override
    public List<User> selectAllUsers() {
        return DB;
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> userMaybe = selectUserById(id);
        if(userMaybe.isEmpty()){
            return 0;

        }
        DB.remove(userMaybe.get());
        return 1;
    }

    @Override
    public int updateUserById(UUID id, User update) {
        return selectUserById(id).map(user -> {
            int indexOfUserToUpdate = DB.indexOf(user);
            if (indexOfUserToUpdate >= 0){
                DB.set(indexOfUserToUpdate, new User(id, update.getUsername(),
                        BCrypt.hashpw(update.getPassword(), BCrypt.gensalt())));
                return 1;
            }
            return 0;
        })
                .orElse(0);

    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

}
