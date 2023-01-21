package app.core.servcies;

import app.core.entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    Category category = Category.Restaurant;

    @Test
    void login() {
        System.out.println("Test 1 started !");
        String email = "EldarJB@gmail.com";
        String password = "12314321";
        assertTrue(customerService.login(email, password));
        System.out.println("Test 1 completed !");
    }

    @Test
    void purchaseCoupon() {
        System.out.println("Test 2 started !");
        String email = "EldarJB@gmail.com";
        String password = "12314321";
        customerService.login(email, password);
        assertAll(() -> customerService.purchaseCoupon(5));
        System.out.println("Test 2 completed !");
    }

    @Test
    void getCustomerCoupon() {
        System.out.println("Test 3 started !");
        String email = "EldarJB@gmail.com";
        String password = "12314321";
        customerService.login(email, password);
        assertAll(() -> System.out.println(customerService.getCustomerCoupon()));
        System.out.println("Test 3 completed !");
    }

    @Test
    void testGetCustomerCoupon() {
        System.out.println("Test 4 started !");
        String email = "EldarJB@gmail.com";
        String password = "12314321";
        customerService.login(email, password);
        assertAll(() -> System.out.println(customerService.getCustomerCoupon(category)));
        System.out.println("Test 4 completed !");
    }

    @Test
    void testGetCustomerCoupon1() {
        System.out.println("Test 5 started !");
        String email = "EldarJB@gmail.com";
        String password = "12314321";
        customerService.login(email, password);
        assertAll(() -> System.out.println(customerService.getCustomerCoupon(1001)));
        System.out.println("Test 5 completed !");
    }

    @Test
    void getCustomerDetails() {
        System.out.println("Test 6 started !");
        String email = "EldarJB@gmail.com";
        String password = "12314321";
        customerService.login(email, password);
        assertAll(() -> System.out.println(customerService.getCustomerDetails()));
        System.out.println("Test 6 completed !");
    }
}