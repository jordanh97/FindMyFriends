package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.User;
import com.findmyfriends.alpha.factory.UserFactory;
import com.findmyfriends.alpha.repository.impl.UserRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {
    @Autowired
    private UserRepositoryImpl userRepository;
    User user = UserFactory.getUser("1234", "12321", "cell", "34.2", "station");

    @Test
    public void a_create() {

        userRepository.create(user);
        assertNotNull(userRepository.getAll());
        System.out.println(userRepository.getAll());

    }

    @Test
    public void b_read() {

        User fromSet = userRepository.read(user.getUser());
        assertNotNull(fromSet);
        System.out.println(userRepository.getAll());
    }

    @Test
    public void c_update() {


        User updatedUser  = UserFactory.getUser("1234", "wowza", "XBone", "34.2", "station");
        userRepository.update(updatedUser);
        Assert.assertNotEquals(user.getDeviceID(), updatedUser.getDeviceID());
        System.out.println(userRepository.getAll());



    }

    @Test
    public void d_delete() {

        assertNotNull(userRepository.getAll());
        userRepository.delete(user.getUser());
        User userTor = userRepository.read(user.getUser());
        assertNull(userTor);
        System.out.println(userRepository.getAll());

    }

}

