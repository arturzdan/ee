package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.user.UserBusiness;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Autowired
    private UserBusiness userBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        PrintWriter out = resp.getWriter();
        user.setType(UserType.USER.toString());
        user.setLastName(req.getParameter("last_name"));
        user.setFirstName(req.getParameter("first_name"));
        user.setMiddleName(req.getParameter("middle_name"));
        user.setAddress(req.getParameter("address"));
        user.setMobile(req.getParameter("mobile"));
        user.setMoney(BigDecimal.valueOf(2000.0));
        user.setDiscount(3);
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        userBusiness.register(user);
        out.println("Registration is complete!" );
    }
}
