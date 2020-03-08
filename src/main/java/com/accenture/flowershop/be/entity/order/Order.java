package com.accenture.flowershop.be.entity.order;

import javax.persistence.*;

import com.accenture.flowershop.be.entity.cart.CartItem;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.enums.OrderStatus;

import java.util.Date;
import java.util.List;

@Entity(name = "Order")
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "sequenceId")
    @SequenceGenerator(name = "sequenceId", sequenceName = "order_sg", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_USER")
    private User user;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<CartItem> order;

    @Column(name = "OPEN_DATE")
    private Date openDate;

    @Column(name = "CLOSE_DATE")
    private Date closeDate;

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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<CartItem> getOrder() {
        return order;
    }

    public void setOrder(List<CartItem> order) {
        this.order = order;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }
}
