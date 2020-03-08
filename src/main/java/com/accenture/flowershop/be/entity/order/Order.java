package com.accenture.flowershop.be.entity.order;

import javax.persistence.*;

import com.accenture.flowershop.be.entity.orderItem.OrderItem;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "Order")
@Table(name = "TB_ORDER")
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
    private List<OrderItem> order;

    @Column(name = "OPEN_DATE")
    private Date openDate;

    @Column(name = "CLOSE_DATE")
    private Date closeDate;

    @Column(name = "DISCOUNT")
    private int discount;

    @Column(name = "VALUE")
    private BigDecimal value;

    public Order() {
    }

    public Order(Long id, User user, OrderStatus orderStatus, List<OrderItem> order, Date openDate, Date closeDate, int discount, BigDecimal value) {
        this.id = id;
        this.user = user;
        this.orderStatus = orderStatus;
        this.order = order;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.discount = discount;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrder() {
        return order;
    }

    public void setOrder(List<OrderItem> order) {
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
