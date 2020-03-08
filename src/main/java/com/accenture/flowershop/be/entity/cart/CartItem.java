package com.accenture.flowershop.be.entity.cart;

import com.accenture.flowershop.be.entity.flower.Flowers;
import com.accenture.flowershop.be.entity.order.Order;

import javax.persistence.*;

@Entity(name = "Cart")
@Table(name = "TB_CART")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequenceId")
    @SequenceGenerator(name = "sequenceId", sequenceName = "cart_sg", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_FLOWER")
    private Flowers flowers;

    @Column(name = "COUNT")
    private int countFlower;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public CartItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flowers getFlowers() {
        return flowers;
    }

    public void setFlowers(Flowers flowers) {
        this.flowers = flowers;
    }

    public int getCountFlower() {
        return countFlower;
    }

    public void setCountFlower(int countFlower) {
        this.countFlower = countFlower;
    }

    public CartItem(Flowers flower, int countFlower) {
        this.flowers = flower;
        this.countFlower = countFlower;
    }
}
