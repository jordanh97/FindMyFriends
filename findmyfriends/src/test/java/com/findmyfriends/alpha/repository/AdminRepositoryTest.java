package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.factory.AdminFactory;
import com.findmyfriends.alpha.repository.impl.AdminRepositoryImpl;
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
public class AdminRepositoryTest {
    @Autowired
    private AdminRepositoryImpl adminRepository;
    Admin admin = AdminFactory.getAdmin("1234", "12321", "cell", "34.2", "station");

    @Test
    public void a_create() {

        adminRepository.create(admin);
        assertNotNull(adminRepository.getAll());
        System.out.println(adminRepository.getAll());

    }

    @Test
    public void b_read() {

        Admin fromSet = adminRepository.read(admin.getAdmin());
        assertNotNull(fromSet);
        System.out.println(adminRepository.getAll());
    }

    @Test
    public void c_update() {


        Admin updatedAdmin  = AdminFactory.getAdmin("1234", "wowza", "XBone", "34.2", "station");
        adminRepository.update(updatedAdmin);
        Assert.assertNotEquals(admin.getDeviceID(), updatedAdmin.getDeviceID());
        System.out.println(adminRepository.getAll());



    }

    @Test
    public void d_delete() {

        assertNotNull(adminRepository.getAll());
        adminRepository.delete(admin.getAdmin());
        Admin adminTor = adminRepository.read(admin.getAdmin());
        assertNull(adminTor);
        System.out.println(adminRepository.getAll());

    }

}

