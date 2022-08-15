package com.kodigoApplaudo.group2.bankingSpring.Controller;

import com.kodigoApplaudo.group2.bankingSpring.Model.Customer;
import com.kodigoApplaudo.group2.bankingSpring.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    @InjectMocks
    ClientController clientController;

    @Mock
    CustomerRepository customerRepository;

    @Test
    void get() {

        List<Customer> customerList = new ArrayList<>();
        Customer customer1 = new Customer(1,"jonh","4584-8451","john123");
        customerList.add(customer1);

        when(customerRepository.findAll()).thenReturn(customerList);

        List<Customer> emptyList = clientController.Get();
        //test if clientControler.Get() is able to retreive customer1 or not
        assertEquals(1,emptyList.size());

        verify(customerRepository,times(1)).findAll();

    }

}