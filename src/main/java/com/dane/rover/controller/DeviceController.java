package com.dane.rover.controller;

import com.dane.rover.entity.Device;
import com.dane.rover.entity.OllamaModel;
import com.dane.rover.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/list")
    public List<Device> devices() {
        return deviceService.listDevices();
    }

    @PostMapping("/add")
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        Device saved = deviceService.createDevice(device);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("{id}/delete")
    public String deleteDevice(@PathVariable long id) {

        try {
            Device device = deviceService.getDeviceById(id);
            deviceService.deleteDevice(device);
            return "Success";
        } catch (RuntimeException e) {
            return e.toString();
        }
    }

    @PostMapping("{id}/add-model")
    public Device addModel(@RequestBody OllamaModel model, long id) {

        Device device = deviceService.getDeviceById(id);

        device.addModel(model);

        return device;
    }

}
