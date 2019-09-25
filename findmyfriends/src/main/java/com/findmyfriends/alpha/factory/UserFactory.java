package com.findmyfriends.alpha.factory;

import com.findmyfriends.alpha.domain.User;

public class UserFactory {
    public static User getUser(String user, String  deviceID, String  login, String  location, String   stationType){
        return new User.Builder().User(user).deviceID(deviceID).login(login).location(location).stationType(stationType).build();
    }
}
