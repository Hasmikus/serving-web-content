package com.intellias.servingwebcontent.web;

import com.intellias.servingwebcontent.repository.DeviceRepository;
import com.intellias.servingwebcontent.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DevicesController {
    @Autowired
    private DeviceRepository repository;

    @GetMapping("/devices")
    public String devices(@RequestParam(name="name", required=false, defaultValue="0") String name, Model model) {
        Device device = repository.findByName(name);

        model.addAttribute("name", name);
        model.addAttribute("owner", device.owner);
        model.addAttribute("id", device.id);

        return "devices";
    }

}