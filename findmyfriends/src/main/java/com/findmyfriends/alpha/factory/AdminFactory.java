package com.findmyfriends.alpha.factory;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.generator.IDGenerator;

public class AdminFactory {
    public static Admin getAdmin(String admin, String  deviceID, String  login, String  location, String   stationType){
        return new Admin.AdminBuilder().Admin(admin).deviceID(deviceID).login(login).location(location).stationType(stationType).build();
    }
}