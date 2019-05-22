package com.findmyfriends.alpha.dao;


import com.findmyfriends.alpha.domain.device.Device;
import com.findmyfriends.alpha.domain.user.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("deviceDao")
public class SpecDeviceDataAccessService implements DeviceDao{

    private static List<Device> DB = new ArrayList<>();


    @Override
    public int insertDevice(UUID id, Device Device) {
        DB.add(new Device(id,
                Device.getUserId(),
                Device.getStatus(),
                Device.getLocationId()));
        return 1;
    }


    @Override
    public List<Device> selectAllDevices() {
        return DB;
    }

    @Override
    public int deleteDeviceById(UUID id) {
        Optional<Device> DeviceMaybe = selectDeviceById(id);
        if(DeviceMaybe.isEmpty()){
            return 0;

        }
        DB.remove(DeviceMaybe.get());
        return 1;
    }

    @Override
    public int updateDeviceById(UUID id, Device update) {
        return selectDeviceById(id)
                .map(device -> {
            int indexOfDeviceToUpdate = DB.indexOf(device);
            if (indexOfDeviceToUpdate >= 0){
                DB.set(indexOfDeviceToUpdate, new Device(id,
                        update.getUserId(),
                        update.getStatus(),
                        update.getLocationId()));
                return 1;
            }
            return 0;
        })
                .orElse(0);

    }

    @Override
    public Optional<Device> selectDeviceById(UUID id) {
        return DB.stream()
                .filter(device -> device.getId().equals(id))
                .findFirst();
    }

}
