package com.example.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.example.entity.Customer;
 
import java.util.List;
 
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
    Customer findByAccountNumber(String accountNumber);
    List<Customer> findByName(String name);
    List<Customer> findByAgeGreaterThan(int age);
    List<Customer> findByCreditCardType(String creditCardType);
    List<Customer> findByBranch(String branch);
    List<Customer> findByMobileNumber(String mobileNumber);
    List<Customer> findByGender(String gender);
    
}

