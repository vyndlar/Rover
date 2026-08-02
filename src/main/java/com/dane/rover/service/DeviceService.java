package com.dane.rover.service;

import com.dane.rover.entity.Device;
import com.dane.rover.repository.DeviceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceService {

  private final DeviceRepository deviceRepository;

  public DeviceService(DeviceRepository deviceRepository) {
    this.deviceRepository = deviceRepository;
  }

  public Device createDevice(Device device) {
    return deviceRepository.save(device);
  }

  public List<Device> listDevices() {
    return deviceRepository.findAll();
  }

  public void deleteDevice(Device device) {
    deviceRepository.delete(device);
  }

  public Device getDeviceById(long id) {
    return deviceRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Device not found"));
  }

  public Device updateDevice(Device device) {
    return deviceRepository.save(device);
  }
}
