package com.findmyfriends.alpha.service;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.factory.AdminFactory;
import com.findmyfriends.alpha.service.impl.AdminServiceImpl;
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
public class AdminServiceTest {
    @Autowired
    private AdminServiceImpl adminService;
    Admin admin = AdminFactory.getAdmin("1234", "12321", "XBone", "34.2", "station");

    @Test
    public void a_create() {


        adminService.create(admin);

        assertNotNull(adminService.getAll());
        System.out.println(adminService.getAll());
    }

    @Test
    public void b_read() {


        assertNotNull(adminService.getAll());
        Admin admin1 = adminService.read(admin.getAdmin());
        assertNotNull(admin1);
        System.out.println(adminService.getAll());


    }

    @Test
    public void c_update() {

        assertNotNull(adminService.getAll());
        Admin admin1 = AdminFactory.getAdmin("1234", "12321", "XBone", "34.2", "station");
        admin1.setAdmin(admin.getAdmin());
        adminService.update(admin1);
        Admin admin2 = adminService.read(admin1.getAdmin());
        assertEquals(admin1, admin2);
        System.out.println(adminService.getAll());

    }

    @Test
    public void d_delete() {
        assertNotNull(adminService.getAll());
        adminService.delete(admin.getAdmin());
        Admin notInSet = adminService.read(admin.getAdmin());
        assertNull(notInSet);
        System.out.println(adminService.getAll());
    }
}
