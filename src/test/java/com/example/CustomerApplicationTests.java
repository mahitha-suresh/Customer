package com.example;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
 
import static org.junit.jupiter.api.Assertions.assertTrue;
 
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerApplicationTests {
 
    @Test
    void contextLoads() {
        // This test ensures that the Spring application context is loaded successfully
        assertTrue(true); // Simple assertion to indicate test success
    }
}

