package app.core.connectionsystem;

import org.springframework.beans.factory.annotation.Autowired;

import app.core.exceptions.CouponSystemException;
import app.core.servcies.AdminService;
import app.core.servcies.ClientService;
import app.core.servcies.CompanyService;
import app.core.servcies.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LoginManager {
    @Autowired
    ApplicationContext ctx;

    public LoginManager() {

    }

    private static LoginManager instance;

    public static LoginManager getInstance() throws CouponSystemException {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    public ClientService login(String name, String password, ClientType client) throws CouponSystemException {

        if (client == (ClientType.Administrator)) {
            AdminService adminService = ctx.getBean(AdminService.class);
            if (adminService.login(name, password)) {
                return adminService;
            }
        }

        if (client == (ClientType.Company)) {
            CompanyService companyService = ctx.getBean(CompanyService.class);
            if (companyService.login(name, password)) {
                return companyService;
            }
        }

        if (client == (ClientType.Customer)) {
            CustomerService customerService = ctx.getBean(CustomerService.class);
            if (customerService.login(name, password)) {
                return customerService;
            }
        }
        throw new CouponSystemException("Wrong email or password please try again !");
    }

}