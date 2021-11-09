package com.intellias.servingwebcontent.web;

import com.intellias.servingwebcontent.model.Device;
import com.intellias.servingwebcontent.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DevicesViewController {
    @Autowired
    private DeviceRepository repository;

    @GetMapping("/devices")
    public String devices(@RequestParam(name="owner", required=false, defaultValue="0") String owner, Model model) {
        List<Device> devices = repository.findByOwner(owner);

        model.addAttribute("devices", devices);

        return "devices";
    }

}