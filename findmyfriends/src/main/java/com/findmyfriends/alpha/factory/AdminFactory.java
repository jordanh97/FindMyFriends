package com.findmyfriends.alpha.factory;

import com.findmyfriends.alpha.domain.Admin;

public class AdminFactory {
    public static Admin getAdmin(String admin, String  deviceID, String  login, String  location, String   stationType){
        return new Admin.Builder().Admin(admin).deviceID(deviceID).login(login).location(location).stationType(stationType).build();
    }
}