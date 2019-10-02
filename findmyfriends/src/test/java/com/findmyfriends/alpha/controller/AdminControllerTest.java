package com.findmyfriends.alpha.controller;

import com.findmyfriends.alpha.domain.Admin;
import com.findmyfriends.alpha.factory.AdminFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/admin";

    @Test
    public void a_create() {

        Admin admin = AdminFactory.getAdmin("1234", "12321", "cell", "34.2", "station");
        admin.setAdmin("12132465");
        ResponseEntity<Admin> postResponse = restTemplate.postForEntity(baseURL + "/new/", admin, Admin.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        Admin admin = restTemplate.getForObject(baseURL + "/find/" + "12132465", Admin.class);
        assertNotNull(admin);
        System.out.println(admin.getAdmin());

    }

    @Test
    public void c_update() {

        Admin admin = restTemplate.getForObject(baseURL + "/find/" + "12132465", Admin.class);
        admin.setDeviceID("XBone");
        restTemplate.put(baseURL + "/update/" + "12132465", admin);
        Admin updatedAdmin = restTemplate.getForObject(baseURL + "/update/" + "12132465", Admin.class);
        assertNotNull(admin);
        System.out.println(admin);

    }

    @Test
    public void e_delete() {

        Admin admin = restTemplate.getForObject(baseURL + "/find/" + "12132465", Admin.class);
        assertNotNull(admin);
        restTemplate.delete(baseURL + "/delete/" + "12132465");

        try {
            admin = restTemplate.getForObject(baseURL + "/find/" + "12132465", Admin.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admin").exchange(baseURL + "/getall", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());

    }


}