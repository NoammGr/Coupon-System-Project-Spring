package app.core.servcies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Category;
import app.core.entities.Company;
import app.core.entities.Coupon;
import app.core.entities.CouponSystemException;
import app.core.repositories.CompanyRepository;
import app.core.repositories.CouponRepository;

@Service
@Transactional
public class CompanyService extends ClientService {

    private Company company;

    public CompanyService() {

    }

    public CompanyService(Company company) {
        super();
        this.company = company;
    }

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public boolean login(String email, String password) throws CouponSystemException {
        if (companyRepository.existsByEmailAndPassword(email, password)) {
            this.company = companyRepository.findByEmailAndPassword(email, password);
            System.out.println("Welcome : " + email + " !");
            return true;
        }
        throw new CouponSystemException("Wrong email or password please try again !");
    }

    public void addCoupon(Coupon coupon) throws CouponSystemException {
        Optional<Coupon> optional = couponRepository.findById(coupon.getId());
        if (optional.isEmpty()) {
            if (couponRepository.findByTitle(coupon.getTitle()) == null) {
                couponRepository.save(coupon);
            }
        } else {
            throw new CouponSystemException("Check the coupon name and try again !");
        }
    }

    public void updateCoupon(Coupon coupon) throws CouponSystemException {
        Coupon tempCoupon = couponRepository.findById(coupon.getId()).orElseThrow(() -> new CouponSystemException("Coupon doesn't exist !"));
        if (tempCoupon.getTitle() == null) {
            System.out.println("Coupon doesn't exist !");
        }
        if (tempCoupon.getId() == coupon.getId() && tempCoupon.getCompany().getId() == coupon.getCompany().getId()) {
            couponRepository.save(coupon);
        } else {
            throw new CouponSystemException("you cannot change company id or coupon id ");
        }
    }

    public void deleteCoupon(int couponId) throws CouponSystemException {
        couponRepository.findById(couponId).orElseThrow(() -> new CouponSystemException("Coupon doesn't exist !"));
        couponRepository.deleteById(couponId);
    }

    public List<Coupon> getCompanyCoupons() throws CouponSystemException {
        try {
            return couponRepository.findAllCouponsByCompanyId(this.company.getId());
        } catch (CouponSystemException e) {
            throw new CouponSystemException("Company coupons not found !" + e);
        }
    }

    public List<Coupon> getCompanyCoupons(Category category) throws CouponSystemException {
        try {
            return couponRepository.findAllByCompanyIdAndCategory(company.getId(), category);
        } catch (CouponSystemException e) {
            throw new CouponSystemException("Company coupons not found !" + e);
        }
    }

    public List<Coupon> getCompanyCoupons(double maxPrice) throws CouponSystemException {
        try {
            return couponRepository.findAllByCompanyIdAndPriceLessThan(company.getId(), maxPrice);
        } catch (CouponSystemException e) {
            throw new CouponSystemException("Company coupons not found !" + e);
        }
    }

    public Company getCompanyDetails() throws CouponSystemException {
        List<Coupon> coupons;
        try {
            coupons = couponRepository.findAllCouponsByCompanyId(this.company.getId());
        } catch (CouponSystemException e) {
            throw new CouponSystemException("Company coupons not found !" + e);
        }
        this.company.setCoupons(coupons);

        return this.company;
    }
}
