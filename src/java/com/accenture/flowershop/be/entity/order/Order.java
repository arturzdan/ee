package java.com.accenture.flowershop.be.entity.order;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.com.accenture.flowershop.be.entity.flower.Flowers;
import java.com.accenture.flowershop.be.entity.user.User;
import java.math.BigDecimal;
import java.util.List;

public class Order {
    @Id
    @GeneratedValue()
    private Long id;
    private User user;
    private List<Flowers> flowers;
    private BigDecimal value;

    public Order(User user, List<Flowers> flowers, BigDecimal value) {
        this.user = user;
        this.flowers = flowers;
        this.value = value;
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
