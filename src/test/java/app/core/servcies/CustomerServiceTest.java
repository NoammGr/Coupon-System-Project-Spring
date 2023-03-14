package app.core.servcies;

import app.core.connectionsystem.ClientType;
import app.core.connectionsystem.LoginManager;
import app.core.entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomerServiceTest {
    @Autowired
    LoginManager loginManager;

    Category category = Category.Restaurant;

    @Test
    void login() {
        System.out.println("Test 1 started !");
        String email = "NoamDov@gmail.com";
        String password = "12343123";
        CustomerService customerService = (CustomerService) loginManager.login(email, password, ClientType.Customer);
        assertTrue(customerService.login(email, password));
        System.out.println("Test 1 completed !");
    }

    @Test
    void purchaseCoupon() {
        System.out.println("Test 2 started !");
        String email = "NoamDov@gmail.com";
        String password = "12343123";
        CustomerService customerService = (CustomerService) loginManager.login(email, password, ClientType.Customer);
        assertAll(() -> customerService.purchaseCoupon(1));
        assertAll(() -> customerService.purchaseCoupon(2));
        assertAll(() -> customerService.purchaseCoupon(3));
        assertAll(() -> customerService.purchaseCoupon(4));
        assertAll(() -> customerService.purchaseCoupon(5));
        System.out.println("Test 2 completed !");
    }

    @Test
    void getCustomerCoupon() {
        System.out.println("Test 3 started !");
        String email = "NoamDov@gmail.com";
        String password = "12343123";
        CustomerService customerService = (CustomerService) loginManager.login(email, password, ClientType.Customer);
        assertAll(() -> System.out.println(customerService.getCustomerCoupon()));
        System.out.println("Test 3 completed !");
    }

    @Test
    void testGetCustomerCoupon() {
        System.out.println("Test 4 started !");
        String email = "NoamDov@gmail.com";
        String password = "12343123";
        CustomerService customerService = (CustomerService) loginManager.login(email, password, ClientType.Customer);
        assertAll(() -> System.out.println(customerService.getCustomerCoupon(category)));
        System.out.println("Test 4 completed !");
    }

    @Test
    void testGetCustomerCoupon1() {
        System.out.println("Test 5 started !");
        String email = "NoamDov@gmail.com";
        String password = "12343123";
        CustomerService customerService = (CustomerService) loginManager.login(email, password, ClientType.Customer);
        assertAll(() -> System.out.println(customerService.getCustomerCoupon(1001)));
        System.out.println("Test 5 completed !");
    }

    @Test
    void getCustomerDetails() {
        System.out.println("Test 6 started !");
        String email = "NoamDov@gmail.com";
        String password = "12343123";
        CustomerService customerService = (CustomerService) loginManager.login(email, password, ClientType.Customer);
        assertAll(() -> System.out.println(customerService.getCustomerDetails()));
        System.out.println("Test 6 completed !");
    }
}