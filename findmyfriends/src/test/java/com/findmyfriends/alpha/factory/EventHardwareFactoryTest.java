package com.findmyfriends.alpha.factory;

import com.findmyfriends.alpha.domain.EventHardware;
import org.junit.Assert;
import org.junit.Test;

public class EventHardwareFactoryTest {

    @Test
    public void getEventHardware(){

        EventHardware eventHardware = EventHardwareFactory.getEventHardware("1234", "12321", "cell", "34.2", "station");
        Assert.assertNotNull(eventHardware);
    }

}
