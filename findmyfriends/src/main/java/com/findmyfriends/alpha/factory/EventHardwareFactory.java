package com.findmyfriends.alpha.factory;

import com.findmyfriends.alpha.domain.EventHardware;


public class EventHardwareFactory {
    public static EventHardware getEventHardware(String Event, String  EventLayoutID, String  hardware, String  location, String  stationType){
        return new EventHardware.Builder().Event(Event).EventLayoutID(EventLayoutID).hardware(hardware).location(location).stationType(stationType).build();
    }
}
