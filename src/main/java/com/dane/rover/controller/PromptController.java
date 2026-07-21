// Controller for user AI requests

package com.dane.rover.controller;


import com.dane.rover.dto.Prompt;
import com.dane.rover.entity.Device;
import com.dane.rover.entity.OllamaModel;
import com.dane.rover.service.DeviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prompt")
public class PromptController {

    private final DeviceService deviceService;

    public PromptController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public String delegateRequest(@RequestBody Prompt prompt) {
        for (Device device : deviceService.listDevices()) {
            if (device.isAvailable()) {
                for (OllamaModel model : device.getModels()) {
                    if (model.getCapabilities().contains(prompt.getNeededCapabilities())) {
                        return "Using " + device.getName();
                    }
                }
            }
        }

        return "No good device or model available";
    }

}
