package app.core.dailyjob;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import app.core.entities.Coupon;
import app.core.entities.CouponSystemException;
import app.core.repositories.CouponRepository;

@Component
public class CouponExpirationDailyJob {

    @Autowired
    CouponRepository couponRepository;

    java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    @Scheduled(timeUnit = TimeUnit.HOURS, fixedRate = 12)
    public void CouponExpirationDaily() {
        this.couponRepository.deleteByEndDateAfter(this.date);
    }
}
