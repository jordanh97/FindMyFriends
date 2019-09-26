package com.findmyfriends.alpha.controller;

import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.service.impl.EventHardwareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/eventhardware")
public class EventHardwareController {

    @Autowired
    @Qualifier("EventHardwareServiceImpl")
    private EventHardwareServiceImpl service;

    @PostMapping("/new")
    public EventHardware create(@RequestBody EventHardware eventHardware){

        return service.create(eventHardware);
    }

    @GetMapping(path = "/find/{id}")
    public EventHardware findById(@PathVariable String id){

        EventHardware eventHardware = service.read(id);

        return eventHardware;
    }

    @PutMapping("/update")
    public void update(@RequestBody EventHardware eventHardware){

        service.update(eventHardware);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getall")
    public Set<EventHardware> getAll(){
        return service.getAll();
    }

}

