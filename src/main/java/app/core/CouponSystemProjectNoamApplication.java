package app.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CouponSystemProjectNoamApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponSystemProjectNoamApplication.class, args);
    }

}
