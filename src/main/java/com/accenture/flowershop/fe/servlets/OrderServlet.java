package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.flower.FlowersBusiness;
import com.accenture.flowershop.be.entity.flower.Flowers;
import com.accenture.flowershop.fe.dto.OrderDataDto;
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

@Service
@WebServlet(urlPatterns = "/flowersServlet")
public class OrderServlet extends HttpServlet {

    @Autowired
    private FlowersBusiness flowersBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idFlower = Long.parseLong(req.getParameter("idFlower"));
        int countFlower = Integer.parseInt(req.getParameter("count"));
        Flowers flowers = flowersBusiness.getFlowers(idFlower);

        HttpSession session = req.getSession();
        OrderDataDto orderDataDto = (OrderDataDto)session.getAttribute("orderDataDto");


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
}
