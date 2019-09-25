package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.factory.EventHardwareFactory;
import com.findmyfriends.alpha.repository.impl.EventHardwareRepositoryImpl;
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
public class EventHardwareRepositoryTest {
    @Autowired
    private EventHardwareRepositoryImpl eventHardwareRepository;
    EventHardware eventHardware = EventHardwareFactory.getEventHardware("1234", "12321", "cell", "34.2", "station");

    @Test
    public void a_create() {

        eventHardwareRepository.create(eventHardware);
        assertNotNull(eventHardwareRepository.getAll());
        System.out.println(eventHardwareRepository.getAll());

    }

    @Test
    public void b_read() {

        EventHardware fromSet = eventHardwareRepository.read(eventHardware.getEvent());
        assertNotNull(fromSet);
        System.out.println(eventHardwareRepository.getAll());
    }

    @Test
    public void c_update() {


        EventHardware updatedEventHardware  = EventHardwareFactory.getEventHardware("1234", "12321", "XBone", "34.2", "station");
        eventHardwareRepository.update(updatedEventHardware);
        Assert.assertNotEquals(eventHardware.getHardware(), updatedEventHardware.getHardware());
        System.out.println(eventHardwareRepository.getAll());



    }

    @Test
    public void d_delete() {

        assertNotNull(eventHardwareRepository.getAll());
        eventHardwareRepository.delete(eventHardware.getEvent());
        EventHardware eventHardwareTor = eventHardwareRepository.read(eventHardware.getEvent());
        assertNull(eventHardwareTor);
        System.out.println(eventHardwareRepository.getAll());

    }

}
