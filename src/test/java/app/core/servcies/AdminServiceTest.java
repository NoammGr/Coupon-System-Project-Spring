package app.core.servcies;

import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceTest {
    @Autowired
    AdminService adminService;

    Company company1 = new Company(1, "Intel", "Intel@gmail.com", "aaabbb");
    List<Coupon> coupons;
    Customer customer1 = new Customer(1, "Noam", "Dov", "NoamDov@gmail.com", "12343123", coupons);


    @Test
    void login() {
        System.out.println("Test 1 started !");
        String email = "admin@admin.com";
        String password = "admin";
        assertTrue(adminService.login(email, password));
        System.out.println("Test 1 completed !");
    }

    @Test
    void addCompany() {
        System.out.println("Test 2 started !");
        assertAll(() -> adminService.addCompany(company1));
        System.out.println("Test 2 completed !");
    }

    @Test
    void updateCompany() {
        System.out.println("Test 3 started !");
        assertAll(() -> adminService.updateCompany(company1));
        System.out.println("Test 3 completed !");
    }

    @Test
    void deleteCompany() {
        System.out.println("Test 4 started !");
        assertAll(() -> adminService.deleteCompany(company1));
        System.out.println("Test 4 completed !");
    }

    @Test
    void getAllCompanies() {
        System.out.println("Test 5 started !");
        assertAll(() -> System.out.println(adminService.getAllCompanies()));
        System.out.println("Test 5 completed !");
    }

    @Test
    void getOneCompany() {
        System.out.println("Test 6 started !");
        assertAll(() -> System.out.println(adminService.getOneCompany(1)));
        System.out.println("Test 6 completed !");
    }

    @Test
    void addCustomer() {
        System.out.println("Test 7 started !");
        assertAll(() -> adminService.addCustomer(customer1));
        System.out.println("Test 7 completed !");
    }

    @Test
    void updateCustomer() {
        System.out.println("Test 8 started !");
        assertAll(() -> adminService.updateCustomer(customer1));
        System.out.println("Test 8 completed !");
    }

    @Test
    void deleteCustomer() {
        System.out.println("Test 9 started !");
        assertAll(() -> adminService.deleteCustomer(customer1));
        System.out.println("Test 9 completed !");
    }

    @Test
    void getAllCustomers() {
        System.out.println("Test 10 started !");
        assertAll(() -> System.out.println(adminService.getAllCustomers()));
        System.out.println("Test 10 completed !");
    }

    @Test
    void getOneCustomer() {
        System.out.println("Test 11 started !");
        assertAll(() -> System.out.println(adminService.getOneCustomer(1)));
        System.out.println("Test 11 completed !");
    }
}