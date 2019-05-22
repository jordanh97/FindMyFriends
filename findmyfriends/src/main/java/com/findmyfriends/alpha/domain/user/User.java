package com.findmyfriends.alpha.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {

    private final UUID id;
    private final String username;
    private final String password;
   // private final List<Device> devices;
   // private final List<FriendsGroup> friendsGroup;
   // private final List<UserPermissions> userPermissions;

    public String getPassword() {
        return password;
    }


    public User(@JsonProperty("id") UUID id,
                @JsonProperty("username") String username,
                @JsonProperty("password") String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
