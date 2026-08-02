package com.dane.rover.controller;

import com.dane.rover.entity.Device;
import com.dane.rover.entity.OllamaModel;
import com.dane.rover.repository.DeviceRepository;
import com.dane.rover.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

  @PutMapping("{id}/update")
  public Device updateDevice(@PathVariable long id, @RequestBody Map<String, Object> updates) {
    Device existing = deviceService.getDeviceById(id);

    if (updates.containsKey("name")) {
      existing.setName((String) updates.get("name"));
    }
    if (updates.containsKey("ollama_endpoint")) {
      existing.setOllama_endpoint((String) updates.get("ollama_endpoint"));
    }

    return deviceService.updateDevice(existing);
  }

  @GetMapping("get-available")
  public List<Device> getAvailable() {
    List<Device> ls = new ArrayList<>();
    for (Device device : deviceService.listDevices()) {
      System.out.println(device);
      if (device.isAvailable()) {
        ls.add(device);
      }
    }
    return ls;
  }

}
