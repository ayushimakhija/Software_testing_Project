package com.fooddel.Services;

import com.fooddel.beans.Customer;
import com.fooddel.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService = new CustomerService();

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomer() {
        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer("pavan", "singh", "8686886135", "hyderabad", "pavansingh9900@gmail.com", "pavan", false), new Customer("ayushman", "khurana", "8869054251", "narsinghpur", "ayushman9ym.19@gmail.com", "ayush", false)).collect(Collectors.toList()));

        System.out.println("testcase 1 hit");
        assertEquals(2, customerService.getCustomers().size());

    }
    //Edge-path-Coverage
    @Test //123436
    public void test_Path123436PositiveCase() {
        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer("pavan", "singh", "8686886135", "hyderabad", "pavansingh9900@gmail.com", "pavan", false)).collect(Collectors.toList()));
        List<Customer>  cr = new ArrayList<>();
        assertEquals(cr, customerService.listOfSubscribeCustomer("pavansingh9900@gamil.com"));
    }

    @Test //123436
    public void test_Path123436NegativeCase() {
        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer("pavan", "singh", "8686886135", "hyderabad", "pavansingh9900@gmail.com", "pavan", false)).collect(Collectors.toList()));
        List<Customer>  cr = new ArrayList<>();
        Customer c1 = new Customer("pavan", "singh", "8686886135", "hyderabad", "pavansingh9900@gmail.com", "pavan", false);
        cr.add(c1);
        assertNotEquals(cr, customerService.listOfSubscribeCustomer("pavansingh9900@gamil.com"));
    }

    @Test //1234536
    public void test_Path1234536PositiveCase() {
        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer("shabbir","sidhpurwala","1234567890","bangalore","shabbir@gmail.com","shabbir",true)).collect(Collectors.toList()));
        List<Customer>  cr = new ArrayList<>();
        Customer c1 = new Customer("shabbir","sidhpurwala","1234567890","bangalore","shabbir@gmail.com","shabbir",true);
        cr.add(c1);
        assertEquals(cr.size(), customerService.listOfSubscribeCustomer("shabbir@gmail.com").size());
    }

    @Test //1234536
    public void test_Path1234536NegativeCase() {
        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer("shabbir","sidhpurwala","1234567890","bangalore","shabbir@gmail.com","shabbir",true)).collect(Collectors.toList()));
        List<Customer>  cr = new ArrayList<>();
        Customer c1 = new Customer("shabbir","sidhpurwala","1234567890","bangalore","shabbir@gmail.com","shabbir",false);
        cr.add(c1);
        assertNotEquals(3, customerService.listOfSubscribeCustomer("shabbir@gmail.com").size());
    }

    @Test //1236
    public void test_Path1236PositiveCase() {
        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer("shabbir","sidhpurwala","1234567890","bangalore","shabbir@gmail.com","shabbir",true)).collect(Collectors.toList()));
        List<Customer>  cr = new ArrayList<>();
        Customer c1 = new Customer("shabbir","sidhpurwala","1234567890","bangalore","shabbir@gmail.com","shabbir",false);
        cr.add(c1);
        assertNotEquals(cr.size(), customerService.listOfSubscribeCustomer("shabbir@gmail.com").size());
    }

    @Test //1236
    public void test_Path1236NegativeCase() {
        when(customerRepository.findAll()).thenReturn(Stream.of(new Customer("shabbir","sidhpurwala","1234567890","bangalore","shabbir@gmail.com","shabbir",true)).collect(Collectors.toList()));
        List<Customer>  cr = new ArrayList<>();
        Customer c1 = new Customer("shabbir","sidhpurwala","1234567890","bangalore","shabbir@gmail.com","shabbir",false);
        cr.add(c1);
        assertNotEquals(3, customerService.listOfSubscribeCustomer("shabbir@gmail.com").size());
    }

    @Test //1234534536
    public void test_Path1234534536PositiveCase() {
        when(customerRepository.findAll()).thenReturn(Stream.of((new Customer("ayushi","makhija","7869054251","narsinghpur","ayushi9ym.19@gmail.com","ayushi",true))).collect(Collectors.toList()));
        List<Customer>  cr = new ArrayList<>();
        Customer c1 = new Customer("ayushi","makhija","7869054251","narsinghpur","ayushi9ym.19@gmail.com","ayushi",true);
        cr.add(c1);
        assertEquals(cr.size(), customerService.listOfSubscribeCustomer("ayushi9ym.19@gmail.com").size());
    }

    @Test //1234534536
    public void test_Path1234534536NegativeCase() {
        when(customerRepository.findAll()).thenReturn(Stream.of((new Customer("ayushi","makhija","7869054251","narsinghpur","ayushi9ym.19@gmail.com","ayushi",true))).collect(Collectors.toList()));
        List<Customer>  cr = new ArrayList<>();
        Customer c1 = new Customer("ayushi","makhija","7869054251","narsinghpur","ayushi9ym.19@gmail.com","ayushi",true);
        cr.add(c1);
        assertNotEquals(4, customerService.listOfSubscribeCustomer("ayushi9ym.19@gmail.com").size());
    }


    }








