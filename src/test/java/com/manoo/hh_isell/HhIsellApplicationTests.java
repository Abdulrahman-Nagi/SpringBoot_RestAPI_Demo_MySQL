package com.manoo.hh_isell;

import com.manoo.hh_isell.exceptionhandling.exceptions.NotFoundException;
import com.manoo.hh_isell.model.Clients;
import com.manoo.hh_isell.model.SalesRep;
import com.manoo.hh_isell.presistance.IClients;
import com.manoo.hh_isell.services.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;



import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
public class HhIsellApplicationTests {



	@Autowired
	ClientService clientService ;


	@TestConfiguration
    static class ClientServiceContextConfiguration {

	    @Bean
        public ClientService clientService() {

	        return new ClientService();
        }

    }

	@MockBean
	IClients clientsRepo;


	@Test
	public void getAllClients() {

	    Clients client1 = new Clients(4444444,"mahmoud","alex");

	    Clients client2 = new Clients(5555555,"ahmed","Cairo");

        List<Clients>  clients = Arrays.asList(client1,client2);
		when(clientsRepo.findAll()).thenReturn(clients);

		assertThat(clientService.getAllClients())
                .hasSize(2)
                .contains(client1,client2)
                .endsWith(client2);

	}


	@Test
    public void findByIDClientTest() {


	    Clients client = new Clients(5555555,"ahmed","Cairo");

	    given(clientsRepo.findById(anyLong())).willReturn(Optional.ofNullable(client));


	    Clients result = clientService.findByID(2);

        assertThat(result.getClient_name()).containsIgnoringCase("ah");


    }


	@Test(expected = NotFoundException.class)
	public void deleteClient () {

		Clients client = new Clients(40333,"Orange","EGYPT");

		clientService.deleteClient(client);

		verify(clientsRepo,times(1)).delete(client);

	}



}
