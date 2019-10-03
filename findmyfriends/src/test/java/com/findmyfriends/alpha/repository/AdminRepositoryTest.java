package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.factory.AdminFactory;
import com.findmyfriends.alpha.repository.impl.AdminRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminRepositoryTest {


    @Autowired
    private AdminRepositoryImpl adminRepository;

    @Test
    public void a_create() {

        Admin admin = AdminFactory.getAdmin("1234", "12321", "cell", "34.2", "station");
        adminRepository.create(admin);

        assertNotNull(adminRepository.getAll());

    }

    @Test
    public void b_read() {

        Admin admin = AdminFactory.getAdmin("1234", "12321", "cell", "34.2", "station");
        adminRepository.create(admin);

        assertNotNull(adminRepository.getAll());

        Admin from = adminRepository.read(admin.getAdmin());

        assertEquals(admin, from);

    }

    @Test
    public void c_update() {

        Admin admin = AdminFactory.getAdmin("1234", "12321", "cell", "34.2", "station");
        adminRepository.create(admin);

        assertNotNull(adminRepository.getAll());

        Admin admins = AdminFactory.getAdmin( "1234", "12321", "cell", "34.2", "station");
        admins.setAdmin(admin.getAdmin());
        adminRepository.update(admins);

        Admin updated = adminRepository.read(admins.getAdmin());

        assertEquals(admins, updated);

    }

    @Test
    public void d_delete() {

        Admin admin = AdminFactory.getAdmin( "1234", "12321", "cell", "34.2", "station");

        adminRepository.delete(admin.getAdmin());

        Admin no = adminRepository.read(admin.getAdmin());

        assertNull(no);

    }
}