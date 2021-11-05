package com.intellias.servingwebcontent;

import com.intellias.servingwebcontent.web.DevicesRESTController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(DevicesRESTController.class)
public class DeviceRESTControllerTests {

    @Autowired
    private MockMvc mvc;

//    @Test
//    public void getAllDevicesAPI() throws Exception
//    {
//        mvc.perform( MockMvcRequestBuilders
//                        .get("/devices")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.devices").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.devices[*].id").isNotEmpty());
//    }
}
