package com.findmyfriends.alpha.service;

import com.findmyfriends.alpha.domain.User;
import com.findmyfriends.alpha.factory.UserFactory;
import com.findmyfriends.alpha.service.Impl.UserServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userService;
    User user = UserFactory.getUser("1234", "12321", "XBone", "34.2", "station");

    @Test
    public void a_create() {


        userService.create(user);

        assertNotNull(userService.getAll());
        System.out.println(userService.getAll());
    }

    @Test
    public void b_read() {


        assertNotNull(userService.getAll());
        User user1 = userService.read(user.getUser());
        assertNotNull(user1);
        System.out.println(userService.getAll());


    }

    @Test
    public void c_update() {

        assertNotNull(userService.getAll());
        User user1 = UserFactory.getUser("1234", "12321", "XBone", "34.2", "station");
        user1.setUser(user.getUser());
        userService.update(user1);
        User user2 = userService.read(user1.getUser());
        assertEquals(user1, user2);
        System.out.println(userService.getAll());

    }

    @Test
    public void d_delete() {
        assertNotNull(userService.getAll());
        userService.delete(user.getUser());
        User notInSet = userService.read(user.getUser());
        assertNull(notInSet);
        System.out.println(userService.getAll());
    }
}
