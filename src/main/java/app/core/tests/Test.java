package app.core.tests;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.Customer;
import app.core.repositories.CompanyRepository;
import app.core.repositories.CouponRepository;
import app.core.repositories.CustomerRepository;
import app.core.servcies.AdminService;
import app.core.servcies.CompanyService;
import app.core.servcies.CustomerService;

@Component
public class Test implements CommandLineRunner {

//    @Autowired
//    private AdminService adminService;

//    @Autowired
//    private CompanyService companyService;

//    @Autowired
//    private CustomerService customerService;

//    @Autowired
//    private CompanyRepository companyRepository;

//    @Autowired
//    private CouponRepository couponRepository;

//    @Autowired
//    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
//        Company company1 = new Company(1, "aaa", "aaabbb@gmail.com", "aaaabbbb");
//		  Company company2 = new Company(0, "bbb", "bbb@gmail.com", "bbbaaa");
//		  Company company3 = new Company(0, "ccc", "ccc@gmail.com", "cccbbb");
//        Company company4 = new Company(4, "ddd", "ddd@gmail.com", "dddccc");
//		  Company company5 = new Company(5, "eee", "eee@gmail.com", "dddeee");
//        Company company6 = new Company(10, "fff", "ffff@gmail.com", "fffddd");

//        Category category = Category.Restaurant;
//        String s = "2022-11-18";
//        Date date = Date.valueOf(s);

//        Coupon coupon = new Coupon(0, company1, category, "Something new ", "Something new ", date, date, 200, 1000, "image");
//        Customer customer = new Customer(0, "Eldar", "JB", "EldarJB@gmail.com", "12314321");
//        Customer customer1 = new Customer(2, "Eli", "Nymrod", "EliNymrodNissim@gmail.com", "12314321");

//		  companyRepository.save(company1);
//		  companyRepository.save(company2);
//		  companyRepository.save(company3);
//		  companyRepository.save(company4);

//		  couponRepository.save(coupon);

//		  customerRepository.save(customer);

//        customerService.login("EldarJB@gmail.com", "12314321");
//        customerService.purchaseCoupon(1);
//        System.out.println(customerService.getCustomerCoupon());
//        System.out.println(customerService.getCustomerCoupon(category));
//        System.out.println(customerService.getCustomerCoupon(1000)); // need to check with Eldar how to make it right !
//        System.out.println(customerService.getCustomerDetails());

//        companyService.login("aaabbb@gmail.com", "aaaabbbb");
//        companyService.addCoupon(coupon);
//        companyService.updateCoupon(coupon);
//        companyService.deleteCoupon(coupon);
//        System.out.println(companyService.getCompanyCoupons());
//        System.out.println(companyService.getCompanyCoupons(category));
//        System.out.println(companyService.getCompanyCoupons(1000)); // need to check with Eldar how to make it right !
//        System.out.println(companyService.getCompanyDetails());

//        adminService.login("admin@admin.com", "admin");
//        adminService.addCompany(company6);
//        adminService.updateCompany(company6);
//        adminService.deleteCompany(company6);
//        System.out.println(adminService.getAllCompanies());
//        System.out.println(adminService.getOneCompany(1));
//        adminService.addCustomer(customer1);
//        adminService.updateCustomer(customer1);
//        adminService.deleteCustomer(customer1);
//        System.out.println(adminService.getAllCustomers());
//        System.out.println(adminService.getOneCustomer(1));
    }

}
