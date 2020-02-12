package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.user.UserBusiness;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.dto.CartDto;
import com.accenture.flowershop.fe.dto.UserDto;
import com.accenture.flowershop.fe.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Service
@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Autowired
    private UserBusiness userBusiness;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        PrintWriter out = resp.getWriter();

        User user = userBusiness.login(name, pass);
        if ((user == null)) {
            out.println("Invalid username or password!" );
        } else {
            UserType userType = UserType.USER;
            if(userType.toString().equals(user.getType())) {
                UserDto userDto = new UserDto();
                userDto.adapter(user);

                HttpSession session = req.getSession();
                List<CartDto> orderList = new ArrayList<>();
                session.setAttribute("orderList", orderList);
                session.setAttribute("userDto", userDto);
                req.getRequestDispatcher("/userServlet").forward(req, resp);
            }else
                resp.sendRedirect("homeAdmin");
        }

    }

}