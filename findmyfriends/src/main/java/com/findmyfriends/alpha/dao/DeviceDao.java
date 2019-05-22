package com.findmyfriends.alpha.dao;

import com.findmyfriends.alpha.domain.device.Device;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeviceDao {

    int insertDevice(UUID id, Device device);


    default int insertDevice(Device device){
        UUID id = UUID.randomUUID();
        return insertDevice(id, device);
    }

    List<Device> selectAllDevices();

    int deleteDeviceById(UUID id);

    int updateDeviceById(UUID id, Device device);

    Optional<Device> selectDeviceById(UUID id);

}
