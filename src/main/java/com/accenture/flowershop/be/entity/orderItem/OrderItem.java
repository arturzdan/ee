package com.accenture.flowershop.be.entity.orderItem;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;

import javax.persistence.*;

@Entity(name = "Order_Item")
@Table(name = "TB_ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequenceId")
    @SequenceGenerator(name = "sequenceId", sequenceName = "cart_sg", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_FLOWER")
    private Flower flowers;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ORDER")
    private Order order;

    @Column(name = "COUNT")
    private int countFlower;


    public OrderItem() {
    }

    public OrderItem(Long id, Flower flowers, Order order, int countFlower) {
        this.id = id;
        this.flowers = flowers;
        this.order = order;
        this.countFlower = countFlower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flower getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower flowers) {
        this.flowers = flowers;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getCountFlower() {
        return countFlower;
    }

    public void setCountFlower(int countFlower) {
        this.countFlower = countFlower;
    }
}
