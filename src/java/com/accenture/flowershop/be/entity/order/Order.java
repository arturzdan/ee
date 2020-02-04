package java.com.accenture.flowershop.be.entity.order;

import javax.persistence.*;
import java.com.accenture.flowershop.be.entity.flower.Flowers;
import java.com.accenture.flowershop.be.entity.user.User;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "Order")
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue()
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER")
    private User user;

    @Column(name = "FLOWERS")
    private List<Flowers> flowers;

    @Column(name = "VALUE")
    private BigDecimal value;

    public Order(User user, List<Flowers> flowers, BigDecimal value) {
        this.user = user;
        this.flowers = flowers;
        this.value = value;
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
