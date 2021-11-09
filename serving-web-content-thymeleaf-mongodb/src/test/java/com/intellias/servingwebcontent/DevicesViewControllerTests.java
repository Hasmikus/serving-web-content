package com.intellias.servingwebcontent;

import com.intellias.servingwebcontent.model.Device;
import com.intellias.servingwebcontent.repository.DeviceRepository;
import com.intellias.servingwebcontent.web.DevicesViewController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DevicesViewController.class)
public class DevicesViewControllerTests {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private DeviceRepository deviceRepository;
    @Test
    public void getAllDevicesByOwner() throws Exception
    {
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("Hasmik-nout-1", "HasmikK"));
        when(deviceRepository.findByOwner("HasmikK")).thenReturn(devices);
        mvc.perform( MockMvcRequestBuilders
                        .get("/devices?owner=HasmikK")
                        .accept(MediaType.TEXT_HTML))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("Hasmik-nout-1")));
    }

}