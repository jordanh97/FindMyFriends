package com.findmyfriends.alpha.controller;

import com.findmyfriends.alpha.domain.device.Device;
import com.findmyfriends.alpha.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("controller/v1/device")
@RestController
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public void addDevice(@RequestBody Device device) {
        deviceService.addDevice(device);
    }

    @GetMapping
    public List<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }

    @GetMapping(path = "{id}")
    public Device getDeviceById(@PathVariable("id") UUID id){
        return deviceService.getDeviceById(id)
                .orElse(null); // Custom Error Code Goes Here
    }

    @DeleteMapping(path = "{id}")
    public void deleteDeviceById(@PathVariable("id") UUID id){
        deviceService.deleteDevice(id);
    }

    @PutMapping(path = "{id}")
    public void updateDevice(@PathVariable("id") UUID id, @RequestBody Device deviceToUpdate) {
        deviceService.updateDevice(id, deviceToUpdate);
    }


}