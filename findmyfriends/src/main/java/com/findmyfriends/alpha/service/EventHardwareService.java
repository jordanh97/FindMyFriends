package com.findmyfriends.alpha.service;

import com.findmyfriends.alpha.domain.EventHardware;
import com.findmyfriends.alpha.service.IService;

import java.util.Set;

public interface EventHardwareService extends IService<EventHardware, String> {
    Set<EventHardware> getAll();
}
