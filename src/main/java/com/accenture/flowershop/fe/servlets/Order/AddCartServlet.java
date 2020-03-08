package com.accenture.flowershop.fe.servlets.Order;

import com.accenture.flowershop.be.business.flower.FlowersBusiness;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.fe.dto.FlowerDto;
import com.accenture.flowershop.fe.dto.OrderDto;
import com.accenture.flowershop.fe.dto.OrderItemDto;
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
import java.util.List;

@Service
@WebServlet(urlPatterns = "/addCartServlet")
public class AddCartServlet extends HttpServlet {
    @Autowired
    private FlowersBusiness flowersBusiness;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        FlowerDto flowerDto = (FlowerDto)session.getAttribute("flowerDto");
        int count = Integer.parseInt(req.getParameter("count"));
        List<OrderItemDto> cartList = (List<OrderItemDto>)session.getAttribute("cartList");
        cartList = addFlowerToCard(flowerDto, count, cartList);
        session.setAttribute("cartList", cartList);
        req.getRequestDispatcher("/catalogServlet").forward(req, resp);
    }

    private List<OrderItemDto> addFlowerToCard(FlowerDto flower, int count, List<OrderItemDto> cartList) {
        OrderItemDto orderItemDto = null;
        for (OrderItemDto it : cartList) {
            if (it.equals(flower))
                orderItemDto = it;
        }

        if (orderItemDto == null)
            cartList.add(new OrderItemDto(flower, new OrderDto(), count));
        else
            orderItemDto.setCount(orderItemDto.getCount() + count);
        return cartList;
    }
}
