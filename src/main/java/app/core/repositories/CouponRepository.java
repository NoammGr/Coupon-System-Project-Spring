package app.core.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Category;
import app.core.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    Coupon findByCategory(Category category);

    Coupon findByEndDate(Date endDate);

    Coupon findByPrice(double price);

    Coupon findByTitle(String title);

    List<Coupon> findByCustomersId(int customers_Id);

    List<Coupon> findAllCouponsByCustomersId(int customerId);

    List<Coupon> findByCustomersIdAndCategory(int customers_Id, Category category);

    List<Coupon> findByCustomersIdAndPriceLessThan(int customers_Id, double price);

    List<Coupon> findAllCouponsByCompanyId(int companyId);

    List<Coupon> findAllByCompanyIdAndCategory(int company_Id, Category category);

    List<Coupon> findAllByCompanyIdAndPriceLessThan(int company_Id, double maxPrice);

    void deleteByEndDateAfter(Date endDate);

}
