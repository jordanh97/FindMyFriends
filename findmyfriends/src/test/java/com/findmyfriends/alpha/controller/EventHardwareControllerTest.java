package com.findmyfriends.alpha.controller;

import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.factory.EventHardwareFactory;
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
public class EventHardwareControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/eventhardware";

    @Test
    public void a_create() {

        EventHardware eventHardware = EventHardwareFactory.getEventHardware("1234", "12321", "cell", "34.2", "station");
        eventHardware.setEvent("12132465");
        ResponseEntity<EventHardware> postResponse = restTemplate.postForEntity(baseURL + "/new/", eventHardware, EventHardware.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse.getBody());

    }

    @Test
    public void b_findById() {

        EventHardware eventHardware = restTemplate.getForObject(baseURL + "/find/" + "12132465", EventHardware.class);
        assertNotNull(eventHardware);
        System.out.println(eventHardware.getEvent());

    }

    @Test
    public void c_update() {

        EventHardware eventHardware = restTemplate.getForObject(baseURL + "/find/" + "12132465", EventHardware.class);
        eventHardware.setHardware("XBone");
        restTemplate.put(baseURL + "/update/" + "12132465", eventHardware);
        EventHardware updatedEventHardware = restTemplate.getForObject(baseURL + "/update/" + "12132465", EventHardware.class);
        assertNotNull(eventHardware);
        System.out.println(eventHardware);

    }

    @Test
    public void e_delete() {

        EventHardware eventHardware = restTemplate.getForObject(baseURL + "/find/" + "12132465", EventHardware.class);
        assertNotNull(eventHardware);
        restTemplate.delete(baseURL + "/delete/" + "12132465");

        try {
            eventHardware = restTemplate.getForObject(baseURL + "/find/" + "12132465", EventHardware.class);
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