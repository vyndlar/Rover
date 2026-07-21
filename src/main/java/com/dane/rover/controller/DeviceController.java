package com.dane.rover.controller;

import com.dane.rover.entity.Device;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeviceController {

    @GetMapping("/devices")
    public List<Device> devices() {
        Device device = new Device();
        List<Device> devices = new ArrayList<>();
        devices.add(device);

        return devices;
    }
}
