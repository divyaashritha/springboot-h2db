/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.divya;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.divya.model.UserDetails;
import com.divya.model.Response;
import com.divya.model.Request;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getUserDetails() throws Exception {
       String uri = "/list";
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
          .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(200, status);
       String content = mvcResult.getResponse().getContentAsString();
       ResponseEntity<List<UserDetails>> user = super.mapFromJson(content, UserDetails[].class);;
       assertTrue(user.length > 0);
    }
    
    @Test
    public void freqCount() throws Exception {
       String uri = "/frequencyCount";
       Request req = new Request();
       req.setPara("beta alpha gamma delta alpha");
       
       String inputJson = super.mapToJson(req);
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
          .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
       
       int status = mvcResult.getResponse().getStatus();
       assertEquals(201, status);
       String content = mvcResult.getResponse().getContentAsString();
       assertEquals(listResp[0].w, "alpha");
       assertEquals(listResp[0].n, "2");
    }
}
