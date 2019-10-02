package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.EventHardware;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EventHardwareRepository extends JpaRepository<EventHardware, String> {

    Set<EventHardware> getAll();
}
