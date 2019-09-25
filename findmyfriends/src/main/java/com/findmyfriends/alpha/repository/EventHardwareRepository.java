package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.repository.IRepository;

import java.util.Set;

public interface EventHardwareRepository extends IRepository<EventHardware, String>{

    Set<EventHardware> getAll();
}
