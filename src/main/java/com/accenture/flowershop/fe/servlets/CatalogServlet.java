package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.AdapterFlower;
import com.accenture.flowershop.be.business.flower.FlowersBusiness;
import com.accenture.flowershop.be.entity.flower.Flowers;
import com.accenture.flowershop.fe.dto.FlowerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@WebServlet(urlPatterns = "/catalogServlet")
public class CatalogServlet extends HttpServlet {
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
        List<Flowers> flowersList = flowersBusiness.getAllFlowers();
        List<FlowerDto> flowersDtoList = new ArrayList<>();
        for (Flowers flowers : flowersList)
            flowersDtoList.add(AdapterFlower.FlowersToDto(flowers));
        req.setAttribute("flowersList", flowersDtoList);
        req.getRequestDispatcher("/catalog.jsp").forward(req, resp);
    }
}
