package app.core.servcies;

import app.core.connectionsystem.ClientType;
import app.core.connectionsystem.LoginManager;
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
    LoginManager loginManager;

    Company company1 = Company.builder().id(1).name("Intel").email("Intel@gmail.com").password("aaabbb").build();
    Company company2 = Company.builder().id(2).name("Applied Materials").email("AMAT@gmail.com").password("aaabbb").build();
    Category category = Category.Restaurant;
    Category category1 = Category.Food;
    Category category2 = Category.Electricity;
    String startDate = "2023-01-15";
    String endDate = "2023-03-27";
    Date start = Date.valueOf(startDate);
    Date end = Date.valueOf(endDate);
    Coupon coupon = Coupon.builder().id(0).company(company1).category(category).title("Discount on supermarket ! ").description("60% less on price ! ").startDate(start).endDate(end).amount(200).price(1000).image("image").build();
    Coupon coupon1 = Coupon.builder().id(0).company(company1).category(category1).title("Discount on chef meal ! ").description("60% less on price ! ").startDate(start).endDate(end).amount(200).price(1000).image("image").build();
    Coupon coupon2 = Coupon.builder().id(0).company(company1).category(category2).title("Discount on toaster oven ! ").description("60% less on price ! ").startDate(start).endDate(end).amount(200).price(1000).image("image").build();
    Coupon coupon3 = Coupon.builder().id(0).company(company2).category(category).title("Discount on supermarket ! ").description("60% less on price ! ").startDate(start).endDate(end).amount(200).price(1000).image("image").build();
    Coupon coupon4 = Coupon.builder().id(0).company(company2).category(category1).title("Discount on chef meal ! ").description("60% less on price ! ").startDate(start).endDate(end).amount(200).price(1000).image("image").build();
    Coupon coupon5 = Coupon.builder().id(0).company(company2).category(category2).title("Discount on toaster oven ! ").description("60% less on price ! ").startDate(start).endDate(end).amount(200).price(1000).image("image").build();

    @Test
    void login() {
        System.out.println("Test 1 started !");
        String email = "Intel@gmail.com";
        String password = "aaabbb";
        CompanyService companyService = (CompanyService) loginManager.login(email, password, ClientType.Company);
        assertTrue(companyService.login(email, password));
        String email1 = "AMAT@gmail.com";
        String password1 = "aaabbb";
        CompanyService companyService1 = (CompanyService) loginManager.login(email1, password1, ClientType.Company);
        assertTrue(companyService1.login(email1, password1));
        System.out.println("Test 1 completed !");
    }

    @Test
    void addCoupon() {
        System.out.println("Test 2 started !");
        CompanyService companyService1 = (CompanyService) loginManager.login("Intel@gmail.com", "aaabbb", ClientType.Company);
        CompanyService companyService2 = (CompanyService) loginManager.login("AMAT@gmail.com", "aaabbb", ClientType.Company);
        assertAll(() -> companyService1.addCoupon(coupon));
        assertAll(() -> companyService1.addCoupon(coupon1));
        assertAll(() -> companyService1.addCoupon(coupon2));
        assertAll(() -> companyService2.addCoupon(coupon3));
        assertAll(() -> companyService2.addCoupon(coupon4));
        assertAll(() -> companyService2.addCoupon(coupon5));
        System.out.println("Test 2 completed !");
    }

    @Test
    void updateCoupon() {
        System.out.println("Test 3 started !");
        String email = "Intel@gmail.com";
        String password = "aaabbb";
        CompanyService companyService = (CompanyService) loginManager.login(email, password, ClientType.Company);
        assertAll(() -> companyService.updateCoupon(coupon));
        System.out.println("Test 3 completed !");
    }

    @Test
    void deleteCoupon() {
        System.out.println("Test 4 started !");
        String email = "Intel@gmail.com";
        String password = "aaabbb";
        CompanyService companyService = (CompanyService) loginManager.login(email, password, ClientType.Company);
        assertAll(() -> companyService.deleteCoupon(coupon));
        System.out.println("Test 4 completed !");
    }

    @Test
    void getCompanyCoupons() {
        System.out.println("Test 5 started !");
        String email = "Intel@gmail.com";
        String password = "aaabbb";
        CompanyService companyService = (CompanyService) loginManager.login(email, password, ClientType.Company);
        assertAll(() -> System.out.println(companyService.getCompanyCoupons()));
        System.out.println("Test 5 completed !");
    }

    @Test
    void testGetCompanyCoupons() {
        System.out.println("Test 6 started !");
        String email = "Intel@gmail.com";
        String password = "aaabbb";
        CompanyService companyService = (CompanyService) loginManager.login(email, password, ClientType.Company);
        assertAll(() -> System.out.println(companyService.getCompanyCoupons(category)));
        System.out.println("Test 6 completed !");
    }

    @Test
    void testGetCompanyCoupons1() {
        System.out.println("Test 7 started !");
        String email = "Intel@gmail.com";
        String password = "aaabbb";
        CompanyService companyService = (CompanyService) loginManager.login(email, password, ClientType.Company);
        assertAll(() -> System.out.println(companyService.getCompanyCoupons(1001)));
        System.out.println("Test 7 completed !");
    }

    @Test
    void getCompanyDetails() {
        System.out.println("Test 8 started !");
        String email = "Intel@gmail.com";
        String password = "aaabbb";
        CompanyService companyService = (CompanyService) loginManager.login(email, password, ClientType.Company);
        assertAll(() -> System.out.println(companyService.getCompanyDetails()));
        System.out.println("Test 8 completed !");
    }
}