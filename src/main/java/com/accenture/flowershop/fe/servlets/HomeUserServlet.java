package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.flower.FlowersBusiness;
import com.accenture.flowershop.be.entity.flower.Flowers;
import com.accenture.flowershop.fe.dto.FlowerDto;
import com.accenture.flowershop.fe.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.faces.flow.Flow;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@WebServlet(urlPatterns = "/homeUser")
public class HomeUserServlet extends HttpServlet {

    @Autowired
    private FlowersBusiness flowersBusiness;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flowers> flowersList = flowersBusiness.getAllFlowers();
        List<FlowerDto> flowersDtoList = new ArrayList<>();
        for (Flowers flowers : flowersList
        ) {
            FlowerDto flowerDto = new FlowerDto();
            flowersDtoList.add(flowerDto.adapter(flowers));
        }
        req.setAttribute("flowersList", flowersDtoList);
        req.getRequestDispatcher("/homeUser.jsp").forward(req, resp);
        List<FlowerDto> flowerDtoList = (List<FlowerDto>)req.getAttribute("flowersList");
        for (FlowerDto it: flowerDtoList
             ) {
            it.getName();
            it.getCount();
            it.getValue();

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
