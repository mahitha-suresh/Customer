package com.example.controller;
 
import com.example.entity.Customer;
import com.example.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
 
@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
 
    @Mock
    private CustomerService customerService;
 
    @InjectMocks
    private CustomerController customerController;
 
    private Customer customer;
    private List<Customer> customerList;
 
    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customerList = Arrays.asList(customer);
    }
 
    @Test
    public void testGetAllCustomers() {
        when(customerService.getAllCustomers()).thenReturn(customerList);
 
        ResponseEntity<List<Customer>> response = customerController.getAllCustomers();
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(customerService, times(1)).getAllCustomers();
    }
 
    @Test
    public void testGetCustomerById() {
        when(customerService.getCustomerById(anyLong())).thenReturn(Optional.of(customer));
 
        ResponseEntity<Customer> response = customerController.getCustomerById(1L);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
        verify(customerService, times(1)).getCustomerById(1L);
    }
 
    @Test
    public void testGetCustomerByIdNotFound() {
        when(customerService.getCustomerById(anyLong())).thenReturn(Optional.empty());
 
        ResponseEntity<Customer> response = customerController.getCustomerById(1L);
 
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(customerService, times(1)).getCustomerById(1L);
    }
 
    @Test
    public void testAddCustomer() {
        when(customerService.saveCustomer(any(Customer.class))).thenReturn(customer);
 
        ResponseEntity<Customer> response = customerController.addCustomer(customer);
 
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());
        verify(customerService, times(1)).saveCustomer(customer);
    }
 
    @Test
    public void testUpdateCustomer() {
        when(customerService.getCustomerById(anyLong())).thenReturn(Optional.of(customer));
        when(customerService.updateCustomer(any(Customer.class))).thenReturn(customer);
 
        ResponseEntity<Customer> response = customerController.updateCustomer(1L, customer);
 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
        verify(customerService, times(1)).getCustomerById(1L);
        verify(customerService, times(1)).updateCustomer(customer);
    }
 
    @Test
    public void testUpdateCustomerNotFound() {
        when(customerService.getCustomerById(anyLong())).thenReturn(Optional.empty());
 
        ResponseEntity<Customer> response = customerController.updateCustomer(1L, customer);
 
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(customerService, times(1)).getCustomerById(1L);
        verify(customerService, times(0)).updateCustomer(customer);
    }
 
    @Test
    public void testDeleteCustomer() {
        when(customerService.getCustomerById(anyLong())).thenReturn(Optional.of(customer));
        doNothing().when(customerService).deleteCustomer(anyLong());
 
        ResponseEntity<Void> response = customerController.deleteCustomer(1L);
 
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(customerService, times(1)).getCustomerById(1L);
        verify(customerService, times(1)).deleteCustomer(1L);
    }
 
    @Test
    public void testDeleteCustomerNotFound() {
        when(customerService.getCustomerById(anyLong())).thenReturn(Optional.empty());
 
        ResponseEntity<Void> response = customerController.deleteCustomer(1L);
 
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(customerService, times(1)).getCustomerById(1L);
        verify(customerService, times(0)).deleteCustomer(anyLong());
    }
}

