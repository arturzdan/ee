package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.user.UserBusiness;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.dto.OrderDataDto;
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
import java.util.List;

@Service
@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {

    @Autowired
    private UserBusiness userBusiness;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        PrintWriter out = response.getWriter();

        User user = userBusiness.login(name, pass);
        if ((user == null)) {
            out.println("Invalid username or password!" );
        } else {
            UserType userType = UserType.USER;
            if(userType.toString().equals(user.getType())) {
                UserDto userDto = new UserDto();
                userDto.adapter(user);

                HttpSession session = request.getSession();
                session.setAttribute("orderDataDto", new OrderDataDto());
                session.setAttribute("userDto", userDto);
                response.sendRedirect("userServlet");

            }else
                response.sendRedirect("homeAdmin");
        }

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        super.doGet(request, response);
    }

}