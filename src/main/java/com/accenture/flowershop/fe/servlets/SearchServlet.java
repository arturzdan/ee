package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.Adapter;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/searchServlet")
public class SearchServlet extends HttpServlet {

    @Autowired
    FlowersBusiness flowersBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BigDecimal min = new BigDecimal(req.getParameter("min"));
        BigDecimal max = new BigDecimal(req.getParameter("max"));
        String name = req.getParameter("search");
        List<Flowers> flowersList = flowersBusiness.getAllFlowers(name, min, max);
        List<FlowerDto> flowersDtoList = new ArrayList<>();
        for (Flowers flowers : flowersList
        ) {
            flowersDtoList.add(Adapter.FlowersToDto(flowers));
        }
        req.setAttribute("flowersList", flowersDtoList);
        req.getRequestDispatcher("/homeUser.jsp").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
}
