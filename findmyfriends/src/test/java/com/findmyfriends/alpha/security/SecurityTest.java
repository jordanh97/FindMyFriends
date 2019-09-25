package com.findmyfriends.alpha.security;


import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.factory.EventHardwareFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/eventhardware";

    @Autowired

    @Before
    public void addDummyData(){

        EventHardware eventHardware = EventHardwareFactory.getEventHardware("1234", "12321", "XBone", "34.2", "station");

        ResponseEntity<EventHardware> postResponse = restTemplate.postForEntity(baseURL + "/new/", eventHardware, EventHardware.class);

    }

    @Test
    public void whenCorrectCredentialsWillBe200() throws Exception {

        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admin").getForEntity(baseURL + "/getall", String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void whenIncorrectCredentialsWillBe401() throws Exception {

        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "admins").getForEntity(baseURL + "/getall", String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());

    }

}
