package app.core.servcies;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyServiceTest {
    @Autowired
    CompanyService companyService;
    Company company1 = new Company(1, "aaa", "aaabbb@gmail.com", "aaaabbbb");

    Category category = Category.Restaurant;
    Category category1 = Category.Food;
    Category category2 = Category.Electricity;
    String startDate = "2023-01-15";
    String endDate = "2023-01-27";
    Date start = Date.valueOf(startDate);
    Date end = Date.valueOf(endDate);

    Coupon coupon = new Coupon(1, company1, category, "Discount on supermarket ! ", "60% less on price ! ", start, end, 200, 1000, "image");
    Coupon coupon1 = new Coupon(0, company1, category1, "Discount on chef meal ! ", "60% less on price ! ", start, end, 200, 1000, "image");
    Coupon coupon2 = new Coupon(0, company1, category2, "Discount on toaster oven ! ", "60% less on price ! ", start, end, 200, 1000, "image");

    @Test
    void login() {
        System.out.println("Test 1 started !");
        String email = "aaabbb@gmail.com";
        String password = "aaaabbbb";
        assertTrue(companyService.login(email, password));
        System.out.println("Test 1 completed !");
    }

    @Test
    void addCoupon() {
        System.out.println("Test 2 started !");
        assertAll(() -> companyService.addCoupon(coupon));
        assertAll(() -> companyService.addCoupon(coupon1));
        assertAll(() -> companyService.addCoupon(coupon2));
        System.out.println("Test 2 completed !");
    }

    @Test
    void updateCoupon() {
        System.out.println("Test 3 started !");
        assertAll(() -> companyService.updateCoupon(coupon));
        System.out.println("Test 3 completed !");
    }

    @Test
    void deleteCoupon() {
        System.out.println("Test 4 started !");
        assertAll(() -> companyService.deleteCoupon(coupon));
        System.out.println("Test 4 completed !");
    }

    @Test
    void getCompanyCoupons() {
        System.out.println("Test 5 started !");
        String email = "aaabbb@gmail.com";
        String password = "aaaabbbb";
        companyService.login(email, password);
        assertAll(() -> System.out.println(companyService.getCompanyCoupons()));
        System.out.println("Test 5 completed !");
    }

    @Test
    void testGetCompanyCoupons() {
        System.out.println("Test 6 started !");
        String email = "aaabbb@gmail.com";
        String password = "aaaabbbb";
        companyService.login(email, password);
        assertAll(() -> System.out.println(companyService.getCompanyCoupons(category)));
        System.out.println("Test 6 completed !");
    }

    @Test
    void testGetCompanyCoupons1() {
        System.out.println("Test 7 started !");
        String email = "aaabbb@gmail.com";
        String password = "aaaabbbb";
        companyService.login(email, password);
        assertAll(() -> System.out.println(companyService.getCompanyCoupons(1001)));
        System.out.println("Test 7 completed !");
    }

    @Test
    void getCompanyDetails() {
        System.out.println("Test 8 started !");
        String email = "aaabbb@gmail.com";
        String password = "aaaabbbb";
        companyService.login(email, password);
        assertAll(() -> System.out.println(companyService.getCompanyDetails()));
        System.out.println("Test 8 completed !");
    }
}