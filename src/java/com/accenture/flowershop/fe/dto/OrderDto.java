package java.com.accenture.flowershop.fe.dto;

import java.com.accenture.flowershop.be.entity.flower.Flowers;
import java.com.accenture.flowershop.be.entity.order.Order;
import java.com.accenture.flowershop.be.entity.user.User;
import java.math.BigDecimal;
import java.util.List;

public class OrderDto {

    private Long id;
    private User user;
    private List<Flowers> flowers;
    private BigDecimal value;

    OrderDto adapter(Order order)
    {
        this.id = order.getId();
        this.user = order.getUser();
        this.flowers = order.getFlowers();
        this.value = order.getValue();
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Flowers> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flowers> flowers) {
        this.flowers = flowers;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
