package com.example.service;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class CustomerService {
 
    private final CustomerRepository customerRepository;
 
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
 
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
 
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
 
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
 
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
 
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
 
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }
 
    public Customer findByAccountNumber(String accountNumber) {
        return customerRepository.findByAccountNumber(accountNumber);
    }
 
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }
 
    public List<Customer> findByAgeGreaterThan(int age) {
        return customerRepository.findByAgeGreaterThan(age);
    }
 
    public List<Customer> findByCreditCardType(String creditCardType) {
        return customerRepository.findByCreditCardType(creditCardType);
    }
 
    public List<Customer> findByBranch(String branch) {
        return customerRepository.findByBranch(branch);
    }
 
    public List<Customer> findByMobileNumber(String mobileNumber) {
        return customerRepository.findByMobileNumber(mobileNumber);
    }
 
    public List<Customer> findByGender(String gender) {
        return customerRepository.findByGender(gender);
    }
}