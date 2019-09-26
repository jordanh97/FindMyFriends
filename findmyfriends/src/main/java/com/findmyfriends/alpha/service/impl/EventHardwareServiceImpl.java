package com.findmyfriends.alpha.service.impl;

import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.repository.EventHardwareRepository;
import com.findmyfriends.alpha.repository.impl.EventHardwareRepositoryImpl;
import com.findmyfriends.alpha.service.EventHardwareService;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("EventHardwareServiceImpl")
public class EventHardwareServiceImpl implements EventHardwareService {

    private EventHardwareServiceImpl service = null;
    private EventHardwareRepository repository;

    public EventHardwareServiceImpl() {
        repository = EventHardwareRepositoryImpl.getRepository();
    }

    public EventHardwareServiceImpl getService(){

        if(service == null){
            return new EventHardwareServiceImpl();
        }
        return service;
    }

    @Override
    public Set<EventHardware> getAll() {
        return this.repository.getAll();
    }

    @Override
    public EventHardware create(EventHardware administrator) {
        return repository.create(administrator);
    }

    @Override
    public EventHardware read(String integer) {
        return repository.read(integer);
    }

    @Override
    public EventHardware update(EventHardware administrator) {
        return repository.update(administrator);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }



}

