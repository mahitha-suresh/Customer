package com.example.service;
 
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
 
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
 
    @Mock
    private CustomerRepository customerRepository;
 
    @InjectMocks
    private CustomerService customerService;
 
    private Customer customer;
    private List<Customer> customerList;
 
    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setUsername("johndoe");
        customer.setAccountNumber("12345678");
        customer.setAge(30);
        customer.setCreditCardType("VISA");
        customer.setBranch("Main");
        customer.setMobileNumber("1234567890");
        customer.setGender("Male");
 
        customerList = Arrays.asList(customer);
    }
 
    @Test
    public void testSaveCustomer() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
 
        Customer savedCustomer = customerService.saveCustomer(customer);
 
        assertEquals(customer, savedCustomer);
        verify(customerRepository, times(1)).save(customer);
    }
 
    @Test
    public void testGetAllCustomers() {
        when(customerRepository.findAll()).thenReturn(customerList);
 
        List<Customer> result = customerService.getAllCustomers();
 
        assertEquals(customerList, result);
        verify(customerRepository, times(1)).findAll();
    }
 
    @Test
    public void testGetCustomerById() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
 
        Optional<Customer> result = customerService.getCustomerById(1L);
 
        assertTrue(result.isPresent());
        assertEquals(customer, result.get());
        verify(customerRepository, times(1)).findById(1L);
    }
 
    @Test
    public void testUpdateCustomer() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
 
        Customer updatedCustomer = customerService.updateCustomer(customer);
 
        assertEquals(customer, updatedCustomer);
        verify(customerRepository, times(1)).save(customer);
    }
 
    @Test
    public void testDeleteCustomer() {
        doNothing().when(customerRepository).deleteById(anyLong());
 
        customerService.deleteCustomer(1L);
 
        verify(customerRepository, times(1)).deleteById(1L);
    }
 
    @Test
    public void testFindByUsername() {
        when(customerRepository.findByUsername(anyString())).thenReturn(customer);
 
        Customer result = customerService.findByUsername("johndoe");
 
        assertEquals(customer, result);
        verify(customerRepository, times(1)).findByUsername("johndoe");
    }
 
    @Test
    public void testFindByAccountNumber() {
        when(customerRepository.findByAccountNumber(anyString())).thenReturn(customer);
 
        Customer result = customerService.findByAccountNumber("12345678");
 
        assertEquals(customer, result);
        verify(customerRepository, times(1)).findByAccountNumber("12345678");
    }
 
    @Test
    public void testFindByName() {
        when(customerRepository.findByName(anyString())).thenReturn(customerList);
 
        List<Customer> result = customerService.findByName("John Doe");
 
        assertEquals(customerList, result);
        verify(customerRepository, times(1)).findByName("John Doe");
    }
 
    @Test
    public void testFindByAgeGreaterThan() {
        when(customerRepository.findByAgeGreaterThan(anyInt())).thenReturn(customerList);
 
        List<Customer> result = customerService.findByAgeGreaterThan(25);
 
        assertEquals(customerList, result);
        verify(customerRepository, times(1)).findByAgeGreaterThan(25);
    }
 
    @Test
    public void testFindByCreditCardType() {
        when(customerRepository.findByCreditCardType(anyString())).thenReturn(customerList);
 
        List<Customer> result = customerService.findByCreditCardType("VISA");
 
        assertEquals(customerList, result);
        verify(customerRepository, times(1)).findByCreditCardType("VISA");
    }
 
    @Test
    public void testFindByBranch() {
        when(customerRepository.findByBranch(anyString())).thenReturn(customerList);
 
        List<Customer> result = customerService.findByBranch("Main");
 
        assertEquals(customerList, result);
        verify(customerRepository, times(1)).findByBranch("Main");
    }
 
    @Test
    public void testFindByMobileNumber() {
        when(customerRepository.findByMobileNumber(anyString())).thenReturn(customerList);
 
        List<Customer> result = customerService.findByMobileNumber("1234567890");
 
        assertEquals(customerList, result);
        verify(customerRepository, times(1)).findByMobileNumber("1234567890");
    }
 
    @Test
    public void testFindByGender() {
        when(customerRepository.findByGender(anyString())).thenReturn(customerList);
 
        List<Customer> result = customerService.findByGender("Male");
 
        assertEquals(customerList, result);
        verify(customerRepository, times(1)).findByGender("Male");
    }
}

