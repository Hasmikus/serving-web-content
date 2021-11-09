package com.intellias.servingwebcontent;

import com.intellias.servingwebcontent.model.Device;
import com.intellias.servingwebcontent.repository.DeviceRepository;
import com.intellias.servingwebcontent.web.DevicesRESTController;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(DevicesRESTController.class)
public class DeviceRESTControllerTests {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private DeviceRepository deviceRepository;
    @Test
    public void getAllDevicesAPI() throws Exception
    {
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("Hasmik-nout-1", "HasmikK"));
        when(deviceRepository.findAll()).thenReturn(devices);
        mvc.perform( MockMvcRequestBuilders
                        .get("/devices-all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").isNotEmpty());
    }
}