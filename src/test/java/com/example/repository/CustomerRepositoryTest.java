package com.example.repository;
 
import com.example.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
 
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {
 
    @Autowired
    private CustomerRepository customerRepository;
 
    private Customer customer;
 
    @BeforeEach
    public void setup() {
        customerRepository.deleteAll();
 
        customer = new Customer();
        customer.setUsername("johndoe");
        customer.setPassword("password123");
        customer.setAccountNumber("12345678");
        customer.setMpin("1234");
        customer.setSecurityQuestion("What is your pet's name?");
        customer.setSecurityAnswer("Fluffy");
        customer.setCreditCardType("VISA");
        customer.setBalance(1000.0);
        customer.setMobileNumber("1234567890");
        customer.setName("John Doe");
        customer.setAge(30);
        customer.setGender("Male");
        customer.setBranch("Main");
 
        customerRepository.save(customer);
    }
 
    @Test
    public void testFindByUsername() {
        Customer foundCustomer = customerRepository.findByUsername("johndoe");
        assertNotNull(foundCustomer);
        assertEquals("John Doe", foundCustomer.getName());
    }
 
    @Test
    public void testFindByAccountNumber() {
        Customer foundCustomer = customerRepository.findByAccountNumber("12345678");
        assertNotNull(foundCustomer);
        assertEquals("John Doe", foundCustomer.getName());
    }
 
    @Test
    public void testFindByName() {
        List<Customer> foundCustomers = customerRepository.findByName("John Doe");
        assertEquals(1, foundCustomers.size());
        assertEquals("johndoe", foundCustomers.get(0).getUsername());
    }
 
    @Test
    public void testFindByAgeGreaterThan() {
        List<Customer> foundCustomers = customerRepository.findByAgeGreaterThan(25);
        assertEquals(1, foundCustomers.size());
        assertEquals("johndoe", foundCustomers.get(0).getUsername());
    }
 
    @Test
    public void testFindByCreditCardType() {
        List<Customer> foundCustomers = customerRepository.findByCreditCardType("VISA");
        assertEquals(1, foundCustomers.size());
        assertEquals("johndoe", foundCustomers.get(0).getUsername());
    }
 
    @Test
    public void testFindByBranch() {
        List<Customer> foundCustomers = customerRepository.findByBranch("Main");
        assertEquals(1, foundCustomers.size());
        assertEquals("johndoe", foundCustomers.get(0).getUsername());
    }
 
    @Test
    public void testFindByMobileNumber() {
        List<Customer> foundCustomers = customerRepository.findByMobileNumber("1234567890");
        assertEquals(1, foundCustomers.size());
        assertEquals("johndoe", foundCustomers.get(0).getUsername());
    }
 
    @Test
    public void testFindByGender() {
        List<Customer> foundCustomers = customerRepository.findByGender("Male");
        assertEquals(1, foundCustomers.size());
        assertEquals("johndoe", foundCustomers.get(0).getUsername());
    }
}

