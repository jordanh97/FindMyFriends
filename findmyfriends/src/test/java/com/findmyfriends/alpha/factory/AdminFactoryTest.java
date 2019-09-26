package com.findmyfriends.alpha.factory;

import com.findmyfriends.alpha.domain.Admin;
import org.junit.Assert;
import org.junit.Test;

public class AdminFactoryTest {

    @Test
    public void getAdmin(){

        Admin Admin = AdminFactory.getAdmin("1234", "12321", "cell", "34.2", "station");
        Assert.assertNotNull(Admin);
    }

}
