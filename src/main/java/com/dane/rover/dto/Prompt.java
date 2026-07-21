package com.dane.rover.dto;

import com.dane.rover.entity.Device;
import com.dane.rover.entity.ModelCapability;
import java.util.Set;

public class Prompt {

    Set<ModelCapability> neededCapabilities;
    String prompt;
    Device device = null;

    public Prompt(Set<ModelCapability> neededCapabilities, String prompt, Device device) {
        this.neededCapabilities = neededCapabilities;
        this.prompt = prompt;
        this.device = device;
    }

    public Set<ModelCapability> getNeededCapabilities() {
        return neededCapabilities;
    }

    public void setNeededCapabilities(Set<ModelCapability> neededCapabilities) {
        this.neededCapabilities = neededCapabilities;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
