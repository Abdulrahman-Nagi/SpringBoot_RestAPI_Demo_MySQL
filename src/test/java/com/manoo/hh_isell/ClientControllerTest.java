package com.manoo.hh_isell;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manoo.hh_isell.model.Clients;
import com.manoo.hh_isell.services.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClientControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;


    @Test
    @WithMockUser(username = "ssss",password = "Mss14",roles = "Admin")
    public void getAllClientsTest() throws Exception{

        Clients client = new Clients(24033,"sssssss","fsgsw");

        given(clientService.saveClient(Mockito.any(Clients.class))).willReturn(client);


        mockMvc.perform(post("/api/v1/client/add").contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(client)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.client_name",is(client.getClient_name())));



    }


    }
