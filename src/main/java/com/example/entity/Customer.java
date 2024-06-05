package com.example.entity;
 
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String username;
    private String password;
    private String accountNumber;
    private String mpin;
    private String securityQuestion;
    private String securityAnswer;
    private String creditCardType;
    private double balance;
    private String mobileNumber;
    private String name;
    private int age;
    private String gender;
    private String branch;
 
  
}