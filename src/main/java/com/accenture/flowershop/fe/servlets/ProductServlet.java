package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.AdapterFlower;
import com.accenture.flowershop.be.business.flower.FlowersBusiness;
import com.accenture.flowershop.be.entity.flower.Flowers;
import com.accenture.flowershop.fe.dto.FlowerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
    @Autowired
    private FlowersBusiness flowersBusiness;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("idFlower");
        Long idFlower = Long.parseLong(id);
        Flowers flowers = flowersBusiness.getFlowers(idFlower);
        FlowerDto flowerDto = AdapterFlower.FlowersToDto(flowers);
        req.getSession().setAttribute("flowerDto",flowerDto);
        req.getRequestDispatcher("/product.jsp").forward(req, resp);
    }
}
