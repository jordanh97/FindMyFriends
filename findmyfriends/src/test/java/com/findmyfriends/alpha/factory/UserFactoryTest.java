package com.findmyfriends.alpha.factory;

import com.findmyfriends.alpha.domain.User;
import org.junit.Assert;
import org.junit.Test;

public class UserFactoryTest {

    @Test
    public void getUser(){

        User User = UserFactory.getUser("1234", "12321", "cell", "34.2", "station");
        Assert.assertNotNull(User);
    }

}
