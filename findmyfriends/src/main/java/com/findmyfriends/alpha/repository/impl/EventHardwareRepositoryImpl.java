package com.findmyfriends.alpha.repository.impl;

import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.repository.EventHardwareRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("EventHardwareInMemory")
public class EventHardwareRepositoryImpl implements EventHardwareRepository {

    private static  EventHardwareRepositoryImpl repository = null;
    private Set<EventHardware> eventHardwares;

    public EventHardwareRepositoryImpl(){
        eventHardwares = new HashSet<>();
    }


    public static EventHardwareRepositoryImpl getRepository() {

        if(repository == null){
            return new EventHardwareRepositoryImpl();
        }
        return repository;
    }

    @Override
    public EventHardware create(EventHardware administrator) {

        eventHardwares.add(administrator);
        return administrator;
    }

    @Override
    public EventHardware read(String id) {

        return eventHardwares.stream().filter(administrator -> administrator.getEvent().equals(id)).findAny().orElse(null);
    }

    @Override
    public EventHardware update(EventHardware administrator) {

        EventHardware inDB = read(administrator.getEvent());

        if(inDB != null){
            eventHardwares.remove(inDB);
            eventHardwares.add(administrator);
            return administrator;
        }

        return null;
    }

    @Override
    public void delete(String id) {

        EventHardware inDB = read(id);
        eventHardwares.remove(inDB);

    }

    @Override
    public Set<EventHardware> getAll() {
        return eventHardwares;
    }

}

