package com.wsdtest.salesservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsdtest.salesservice.payload.CustomerResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllRegisteredCustomers() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/customers").accept(MediaType.APPLICATION_JSON)).andReturn();

        assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus(), "Endpoint return 200 status");
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerResponse customerResponse = objectMapper.readValue(contentAsString, CustomerResponse.class);
        assertEquals(4, customerResponse.getTotalElements());
    }

}
