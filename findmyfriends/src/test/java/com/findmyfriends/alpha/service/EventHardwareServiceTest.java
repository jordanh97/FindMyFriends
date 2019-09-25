package com.findmyfriends.alpha.service;

import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.factory.EventHardwareFactory;
import com.findmyfriends.alpha.service.Impl.EventHardwareServiceImpl;
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
public class EventHardwareServiceTest {
    @Autowired
    private EventHardwareServiceImpl eventHardwareService;
    EventHardware eventHardware = EventHardwareFactory.getEventHardware("1234", "12321", "XBone", "34.2", "station");

    @Test
    public void a_create() {


        eventHardwareService.create(eventHardware);

        assertNotNull(eventHardwareService.getAll());
        System.out.println(eventHardwareService.getAll());
    }

    @Test
    public void b_read() {


        assertNotNull(eventHardwareService.getAll());
        EventHardware eventHardware1 = eventHardwareService.read(eventHardware.getEvent());
        assertNotNull(eventHardware1);
        System.out.println(eventHardwareService.getAll());


    }

    @Test
    public void c_update() {

        assertNotNull(eventHardwareService.getAll());
        EventHardware eventHardware1 = EventHardwareFactory.getEventHardware("1234", "12321", "XBone", "34.2", "station");
        eventHardware1.setEvent(eventHardware.getEvent());
        eventHardwareService.update(eventHardware1);
        EventHardware eventHardware2 = eventHardwareService.read(eventHardware1.getEvent());
        assertEquals(eventHardware1, eventHardware2);
        System.out.println(eventHardwareService.getAll());

    }

    @Test
    public void d_delete() {
        assertNotNull(eventHardwareService.getAll());
        eventHardwareService.delete(eventHardware.getEvent());
        EventHardware notInSet = eventHardwareService.read(eventHardware.getEvent());
        assertNull(notInSet);
        System.out.println(eventHardwareService.getAll());
    }
}
