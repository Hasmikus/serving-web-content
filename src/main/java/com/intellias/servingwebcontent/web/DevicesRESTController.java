package com.intellias.servingwebcontent.web;

import com.intellias.servingwebcontent.model.Device;
import com.intellias.servingwebcontent.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.Optional;

@RestController
public class DevicesRESTController {
    @Autowired
    private DeviceRepository repository;

    @GetMapping(value = "/devices-all")
    public List<Device> getAllDevices() {
        List<Device> devices = repository.findAll();
        return devices;
    }

    @GetMapping(value = "/device/{deviceId}")
    public @ResponseBody
    Optional<Device> getDeviceData(@PathVariable String deviceId) {
        Optional<Device> device = repository.findById(deviceId);
        return device;
    }

    @RequestMapping(value="/save_device",method = RequestMethod.POST)
    public String save(@ModelAttribute("device") Device device){
        repository.save(device);
        return "redirect:/";
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable(name="id") String id){
        repository.deleteDeviceById(id);
        return "redirect:/";
    }
}